package com.study.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * String 工具类
 * 
 * @author KLP
 * @date 2017年12月18日下午4:57:16
 */
public class StringUtil {

	private static Pattern linePattern = Pattern.compile("_(\\w)");
	private static Pattern humpPattern = Pattern.compile("[A-Z]");

	/**
	 * 下划线转驼峰
	 * 
	 * @author : KLP
	 * @param str
	 * @return
	 */
	public static String lineToHump(String str) {
		if (null == str || "".equals(str)) {
			return str;
		}
		str = str.toLowerCase();
		Matcher matcher = linePattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);
		str = sb.toString();
		str = str.substring(0, 1).toUpperCase() + str.substring(1);
		return str;
	}

	/**
	 * 驼峰转下划线,效率比较高
	 * 
	 * @author : KLP
	 * @param str
	 * @return
	 */
	public static String humpToLine(String str) {
		Matcher matcher = humpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, "_" + matcher.group(1).toLowerCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 驼峰转下划线 (简单写法，效率低于{@link #humpToLine(String)})
	 * 
	 * @author : KLP
	 * @param str
	 * @return
	 */
	public static String humpToLine2(String str) {
		return str.replaceAll("[A-Z]", "_$0").toLowerCase();
	}

	/**
	 * 首字母转小写
	 * 
	 * @author : KLP
	 * @param str
	 * @return
	 */
	public static String toLowerCaseFirstOne(String str) {
		if (StringUtils.isBlank(str)) {
			return str;
		}
		if (Character.isLowerCase(str.charAt(0))) {
			return str;
		} else {
			return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1))
					.toString();
		}
	}

	/**
	 * 首字母转大写
	 * 
	 * @author : KLP
	 * @param str
	 * @return
	 */
	public static String toUpperCaseFirstOne(String str) {
		if (StringUtils.isBlank(str)) {
			return str;
		}
		if (Character.isUpperCase(str.charAt(0))) {
			return str;
		} else {
			return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1))
					.toString();
		}
	}

	/**
	 * object转string
	 * 
	 * @author : KLP
	 * @param object
	 * @return
	 */
	public static String getString(Object object) {
		return getString(object, "");
	}

	public static String getString(Object object, String defaultValue) {
		if (null == object) {
			return defaultValue;
		}
		try {
			return object.toString();
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * object转Integer
	 * 
	 * @author : KLP
	 * @param object
	 * @return
	 */
	public static int getInt(Object object) {
		return getInt(object, -1);
	}

	public static int getInt(Object object, int defaultValue) {
		if (null == object) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(object.toString());
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * object转Boolean
	 * 
	 * @author : KLP
	 * @param object
	 * @return
	 */
	public static boolean getBoolean(Object object) {
		return getBoolean(object, false);
	}

	public static boolean getBoolean(Object object, Boolean defaultValue) {
		if (null == object) {
			return defaultValue;
		}
		try {
			return Boolean.valueOf(object.toString());
		} catch (Exception e) {
			return defaultValue;
		}
	}

}
