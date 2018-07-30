package com.dust.datautil.strtool;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.dust.common.CommonConstants;
/**
 * 
 * @author min
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface Strable {
	/**
	 * 每个数据都拥有自己的tag，根据tag就可以找到解析的办法，可以用来快速的反序列化
	 * @return
	 */
	public String tag() default "";

	/**
	 * 结构化的数据，需要符号分隔，默认tab分隔
	 * @return
	 */
	public char separator() default '\t';

	/**
	 * 文件路径中包含的关键字，标记出是什么数据。默认为空字符串，如果不填写，则需要根据文件开头的标记物来识别。
	 * 可以设置多个关键字，符合其中任何一个，即判定true
	 * 
	 * @return
	 */
	public String[] keys() default {};

	/**
	 * item 的index
	 * 
	 */
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD })
	public static @interface index {
		public int i();
	}

	/**
	 * 标注该类字段应被序列化为一个json串
	 * 
	 */
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD })
	public static @interface json {
	}

	/**
	 * 标注该类字段应被序列化为一个特殊日期的字符串,可以指定日期的格式
	 * 
	 */
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD })
	public static @interface date {
		public String format() default CommonConstants.DATE_PATTERN;
	}
	
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD })
	public static @interface dateTime {
		public String format() default CommonConstants.DATETIME_PATTERN;
	}
	
	/**
	 * 
	 *
	 */
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD })
	public static @interface yearMonth{
	}
	
	/**
	 * 
	 * @author min
	 *
	 */
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD })
	public static @interface feature{
	}
	
	
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD})
	public static @interface target{
	}
	
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ElementType.FIELD})
	public static @interface idx{
	}
	
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public static @interface timeStamp{
	}

	/**
	 * 标注该类字段应被序列化为一个字符串
	 * 
	 */
	@Deprecated
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.FIELD })
	public static @interface string {
	}
}
