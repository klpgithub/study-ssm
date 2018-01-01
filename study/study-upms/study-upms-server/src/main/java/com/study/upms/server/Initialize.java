package com.study.upms.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.common.base.BaseInterface;

/**
 * 系统接口
 * 
 * @author KLP 2018年1月1日上午11:13:21
 */
public class Initialize implements BaseInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(Initialize.class);

	@Override
	public void init() {
		LOGGER.info(">>>>> 系统初始化");
	}

}
