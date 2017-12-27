package com.study.upms.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * upms服务启动类
 * 
 * @author KLP
 * @date 2017年12月27日上午9:45:40
 */
public class StudyUpmsRpcServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudyUpmsRpcServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info(">>>>> study-upms-rpc-service 正在启动 <<<<<<");
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
		LOGGER.info(">>>>> study-upms-rpc-service 启动完成<<<<<<");
	}

}
