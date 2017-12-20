package com.study.common.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * request工具类
 * 
 * @author KLP
 * @date 2017年12月20日下午5:53:44
 */
public class RequestUtil {

	/**
	 * 移除request指定参数
	 * 
	 * @author : KLP
	 * @param request
	 * @param paramName
	 * @return
	 */
	public String removeParam(HttpServletRequest request, String paramName) {
		String queryString = "";
		Enumeration keys = request.getParameterNames();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			if (key.contains(paramName)) {
				continue;
			}
			if ("".equals(queryString)) {
				queryString = key + "=" + request.getParameter(key);
			} else {
				queryString += "&" + key + "=" + request.getParameter(key);
			}
		}
		return queryString;
	}
	
	
	
}
