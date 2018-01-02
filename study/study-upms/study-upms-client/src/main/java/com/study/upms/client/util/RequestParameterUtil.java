package com.study.upms.client.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * request参数工具类
 * 
 * @author KLP 2018年1月2日下午11:50:55
 */
public class RequestParameterUtil {

	/**
	 * 移除URL中的code,username参数
	 * @param request
	 * @return
	 */
	public static String getParameterWithoutCode(HttpServletRequest request) {
		StringBuffer backUrl = request.getRequestURL();
		String params = "";
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
			if (!"upms_code".equals(entry.getKey()) && !"upms_username".equals(entry.getKey())) {
				if ("".equals(params)) {
					params = entry.getKey() + "=" + entry.getValue()[0];
				} else {
					params += "&" + entry.getKey() + "=" + entry.getValue()[0];
				}
			}
		}
		if (!StringUtils.isBlank(params)) {
			backUrl = backUrl.append("?").append(params);
		}
		return backUrl.toString();
	}

}
