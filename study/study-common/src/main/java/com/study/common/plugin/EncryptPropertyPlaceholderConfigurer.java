package com.study.common.plugin;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.study.common.util.AESUtil;

/**
 * 支持加密配置文件插件
 * 
 * @author KLP
 * @date 2017年12月18日上午11:09:11
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private String[] propertyNames = { "master.jdbc.password", "slave.jdbc.password", "generator.jdbc.password",
			"master.redis.password" };

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		for (String p : propertyNames) {
			if (p.equalsIgnoreCase(propertyName)) {
				return AESUtil.aesDecode(propertyValue);
			}
		}
		return super.convertProperty(propertyName, propertyValue);
	}
}
