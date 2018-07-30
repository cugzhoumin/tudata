package com.dust.datautil.strtool;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.collections.BeanMap;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import com.dust.common.CommonConstants;
import com.dust.datautil.dataframe.YearMonth;
import com.dust.datautil.dataframe.YearMonthUtils;
import com.google.gson.GsonBuilder;


/**
 */
@SuppressWarnings("deprecation")
public class TranslateService {
    private final Set<TextClass> objClasses;
    private final Map<Class<?>, List<Field>> objectAnnotationFields = new HashMap<Class<?>, List<Field>>();
    private final GsonBuilder gsonBuilder = new GsonBuilder();
    private Logger log = Logger.getLogger(getClass());
    private Set<String> seperators = new HashSet<String>();
    /**
     * 注册默认支持的解析对象类型
     */
    static {
        DateConverter dateConverter = new DateConverter();
        dateConverter.setPattern(CommonConstants.DATE_PATTERN);
        ConvertUtils.register(dateConverter, Date.class);
    }
    /**
     * 指定反序列化文本类型的反序列化服务(只处理指定的文本类型)。降低文本反序列化冲突的可能性。
     *
     * @param cls
     *            指定的反序列化对象类型(类需要声明@Stringable)
     */
    public TranslateService(Class<?>[] cls) {
        if (!ArrayUtils.isEmpty(cls)) {

            this.objClasses = new HashSet<TextClass>();
            for (Class<?> cl : cls) {
                TextClass tc = new TextClass(cl);
                this.seperators.add(String.valueOf(cl.getAnnotation(Strable.class).separator()));
                this.objClasses.add(tc);
                Field[] fields = cl.getDeclaredFields();
                Class<?> pcl = cl.getSuperclass();
                while (!pcl.equals(Object.class)) {
                    if (pcl.getAnnotation(Strable.class) != null) {
                        fields = (Field[]) ArrayUtils.addAll(fields, pcl.getDeclaredFields());
                    }
                    pcl = pcl.getSuperclass();
                }
                // 防止domain中声明Stringable.index顺序不对，先排序
                Field[] sortedFields = new Field[fields.length];
                for (Field f : fields) {
                    Strable.index a = f.getAnnotation(Strable.index.class);
                    if (a != null) {
                        sortedFields[a.i() - 1] = f;
                    }
                }
                List<Field> annotationFields = new ArrayList<Field>();
                for (Field f : sortedFields) {
                    if (f != null)
                        annotationFields.add(f);
                }
                this.objectAnnotationFields.put(cl, annotationFields);
            }
        } else {
            throw new RuntimeException("未指定支持的反序列化文本类型");
        }
        gsonBuilder.serializeSpecialFloatingPointValues();
    }

    /**
     * 反序列化文本为一个@Stringable的对象
     *
     * @param txt 要序列化的文本
     * @return 如果是数据中心不可识别的输入数据，或在反序列化输入数据时出现异常，则返回null。
     */
    public Object getObject(String txt) throws TsException {
        if (StringUtils.isNotEmpty(txt)) {
            for (String seperator : this.seperators) {
                String[] items = txt.split(seperator);
                for (TextClass tc : this.objClasses) {
                    if (tc.getTag().equals(items[0])) {
                        String fieldName = null;
                        try {
                            Object obj = tc.cls.newInstance();
							BeanMap m = new BeanMap(obj);
                            for (Field field : objectAnnotationFields.get(tc.cls)) {
                                int i = field.getAnnotation(Strable.index.class).i();
                                if (i < items.length && StringUtils.isNotEmpty(items[i])) {
                                    fieldName = field.getName();
                                    // 如果field声明了json注解，说明应该反序列化一个json字符串，否则应该直接进行强制转换
                                    Strable.json j = field.getAnnotation(Strable.json.class);
                                    // 如果field声明了date注解，说明反序列化时候需要使用特殊的日期格式
                                    Strable.date d = field.getAnnotation(Strable.date.class);
                                    Strable.dateTime dtTime = field.getAnnotation(Strable.dateTime.class);
                                    Strable.yearMonth yeMonth = field.getAnnotation(Strable.yearMonth.class);
                                    if (j != null) {
                                        m.getWriteMethod(fieldName).invoke(obj, gsonBuilder.create().fromJson(items[i], field.getGenericType()));
                                    }else if (dtTime != null) {
										Date dateTime = DateUtils.parseDate(StringUtils.trim(items[i]), CommonConstants.DATE_PATTERNS);
										m.getWriteMethod(fieldName).invoke(obj,dateTime);
									} else if (d != null) {
                                    	Date date = DateUtils.parseDate(StringUtils.trim(items[i]), CommonConstants.DATE_PATTERNS);
                                    	m.getWriteMethod(fieldName).invoke(obj,date);
                                    } else if(yeMonth != null){
                                    	m.getWriteMethod(fieldName).invoke(obj, YearMonthUtils.parseYm(items[i]));
                                    }else if(StringUtils.isNotEmpty(items[i]) && !StringUtils.equals(items[i], "NULL") && !StringUtils.equals(items[i], "null")
                                    		&& !StringUtils.equals(items[i], "\\N")){
                                        m.getWriteMethod(fieldName).invoke(obj, ConvertUtils.convert(items[i], field.getType()));
                                    }
                                }
                            }
                            return obj;
                        } catch (InstantiationException e) {
                            throw new TsException("newInstance InstantiationException", e);
                        } catch (IllegalAccessException e) {
                            throw new TsException("newInstance IllegalAccessException or " + tc.cls.getName() + "." + fieldName + " 没有public的setter", e);
                        } catch (IllegalArgumentException e) {
                            throw new TsException(tc.cls.getName() + "." + fieldName + "setter参数类型错误", e);
                        } catch (InvocationTargetException e) {
                            throw new TsException("调用" + tc.cls.getName() + "." + fieldName + "setter时候发生错误", e);
                        } catch (ParseException e) {
                            throw new TsException("转换日期" + tc.cls.getName() + "." + fieldName + "时候发生错误", e);
                        }
                    }
                }
            }
        }
        // modified at 2015-02-25 xiewei
        // 无法反序列化文本时，只要记录一下就好
        // throw new TranslateException("无法将文本反序列化:" + txt);
        log.debug("无法将文本反序列化:" + txt);
        return txt;
    }

    /**
     * 默认的tostring，包括tag
     * @param obj
     * @return
     * @throws TsException
     */
    public String toString(Object obj) throws TsException{
    	return toString(obj, true);
    }
    
    /**
     * 把一个@Stringable的对象序列化为文本
     *
     * @param obj 要序列化的对象
     * @return
     */
    public String toString(Object obj,boolean includeTag) throws TsException {

        if (obj != null) {
            Strable an = obj.getClass().getAnnotation(Strable.class);
            if (an == null)
                throw new RuntimeException(obj.getClass().getName() + "没有声明注解@Stringable");
            StringBuilderWithSeparator sb = new StringBuilderWithSeparator(String.valueOf(an.separator()));
            if (includeTag) {				
            	sb.append(an.tag());
			}
            BeanMap m = new BeanMap(obj);
            String fieldName = null;
            try {
                if (!this.objectAnnotationFields.containsKey(obj.getClass()))
                    throw new TsException("新建的TranslateService对象，未设置" + obj.getClass() + "的解析");
                for (Field field : this.objectAnnotationFields.get(obj.getClass())) {
                    fieldName = field.getName();
                    Object fieldValue = m.getReadMethod(fieldName).invoke(obj);
                    if (fieldValue != null) {
                        // 如果field声明了json注解，说明应该序列化为一个json字符串，否则应该直接进行强制转换
                        Strable.json j = field.getAnnotation(Strable.json.class);
                        // 如果field声明了date注解，说明反序列化时候需要使用特殊的日期格式
                        Strable.date d = field.getAnnotation(Strable.date.class);
                        Strable.dateTime dTime = field.getAnnotation(Strable.dateTime.class);
                        Strable.yearMonth yearMonth = field.getAnnotation(Strable.yearMonth.class);
                        if (j != null) {
                            sb.append(gsonBuilder.create().toJson(fieldValue));
                        }else if (dTime != null) {
                        	sb.append(DateFormatUtils.format((Date) fieldValue, dTime.format()));
						} else if (d != null) {
                            sb.append(DateFormatUtils.format((Date) fieldValue, d.format()));
                        } else if (fieldValue instanceof Date) {
                            sb.append(DateFormatUtils.format((Date) fieldValue, CommonConstants.DATE_PATTERN));
                        } else if(yearMonth != null){
                        	sb.append(YearMonthUtils.formatYm((YearMonth)fieldValue));
                        }else {
                            sb.append(fieldValue.toString());
                        }
                    } else
                        sb.append("");
                }
            } catch (InvocationTargetException e) {
                throw new TsException("调用" + obj.getClass() + "." + fieldName + "的getter出错", e);
            } catch (IllegalArgumentException e) {
                throw new TsException(obj.getClass() + "." + fieldName + "的getter参数类型错误", e);
            } catch (IllegalAccessException e) {
                throw new TsException(obj.getClass() + "." + fieldName + "没有public的getter", e);
            }
            return sb.toString();
        } else {
            return "";
        }

    }
    /**
     * 支持反序列化的文本类型
     *
     */
    private final static class TextClass {
        private final Class<?> cls;
        private final String tag;

        private TextClass(Class<?> cls) {
            this.cls = cls;
            Strable ant = cls.getAnnotation(Strable.class);
            if (ant != null) {
                this.tag = ant.tag();
            } else {
                throw new TsException(cls.getName() + "应声明注解@StringableClass");
            }
        }

        public String getTag() {
            return tag;
        }

    }
    /**
     * 序列化或反序列化@Stringable对象时候抛出的异常，一般包括以下几种可能：
     * <ul>
     * <li>尝试序列化未声明为@Stringable的对象</li>
     * <li>已声明了@Stringable的对象，但没有声明为@Stringable.index的域</li>
     * <li>新建的TranslateService对象，未设置对某个@Stringable对象的支持，但却尝试去序列化这个对象</li>
     * <li>声明了@Stringable.index的域，但index未按正确顺序声明</li>
     * <li>声明了@Stringable.index的域，但域没有对应的public getter&&setter</li>
     * </ul>
     *
     */
    public static class TsException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        TsException(String msg) {
            super(msg);
        }

        TsException(String msg, Throwable e) {
            super(msg, e);
        }
    }
}
