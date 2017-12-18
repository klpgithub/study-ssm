package com.study.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie操作工具类
 * 
 * @author KLP
 * @date 2017年12月18日上午11:48:34
 */
public class CookieUtil {

	/**
	 * 设置cookie
	 * 
	 * @author : KLP
	 * @param response
	 * @param name
	 * @param value
	 * @param path
	 * @param maxAge
	 */
	public static void setCookie(HttpServletResponse response, String name, String value, String path, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath(path);
		if (maxAge > 0) {
			cookie.setMaxAge(maxAge);
		}
		response.addCookie(cookie);
	}

	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
		setCookie(response, name, value, "/", maxAge);
	}

	public static void setCookie(HttpServletResponse response, String name, String value) {
		setCookie(response, name, value, "/", 3600);
	}

	public static void setCookie(HttpServletResponse response, String name) {
		setCookie(response, name, "", "/", 3600);
	}

	/**
	 * 获取cookie
	 * 
	 * @author : KLP
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getCookie(HttpServletRequest request, String name) {
		String value = "";
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					value = cookie.getValue();
					break;
				}
			}
		}
		return value;
	}

	/**
	 * 删除cookie
	 * 
	 * @author : KLP
	 */
	public static void removeCookie(HttpServletResponse response, String name) {
		setCookie(response, name, "", "/", 0);
	}

}
