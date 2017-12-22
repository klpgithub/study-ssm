package com.sys.demo.rpc.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoRpcServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoRpcServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info("DemoRpcServiceApplication 正在启动 ... ");
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
		LOGGER.info("DemoRpcServiceApplication  启动完成	<<<<<");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
