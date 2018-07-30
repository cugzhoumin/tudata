/**
 * 
 */
package com.dust.common;

import java.nio.charset.Charset;

/**
 * @author min
 *
 */
public class CommonConstants {
	
	public static final Charset ENCODE = Charset.forName("utf-8");
	
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	
	public static final String DATE_PATTERN2 = "yyyy/MM/dd";
	
	public static final String DATE_PATTERN_POINT = "yyyy.MM.dd";

	public static final String DATE_PATTERN_POINT2 = "yyyy.MM";
	
	public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static final String[] DATE_PATTERNS = new String[] {DATE_PATTERN,DATE_PATTERN2,DATE_PATTERN_POINT,DATE_PATTERN_POINT2,DATETIME_PATTERN};

	/**
	 * 默认的分隔符
	 */
	public static final String DEFAULT_SEPARATOR = String.valueOf('\001');
	
	/**
	 * 逗号分隔符
	 */
	public static final String COMMA_SEPARATOR = String.valueOf(',');
	
	/**
	 * 制表分隔符
	 */
	public static final String TAB_SEPARATOR = String.valueOf('\t');

}
