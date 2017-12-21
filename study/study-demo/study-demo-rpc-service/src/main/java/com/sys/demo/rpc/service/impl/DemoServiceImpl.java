package com.sys.demo.rpc.service.impl;

import com.sys.demo.rpc.api.DemoService;

/**
 * 实现DemoService接口
 * 
 * @author KLP
 * @date 2017年12月21日下午5:01:37
 */
public class DemoServiceImpl implements DemoService {

	@Override
	public String sayHello(String name) {
		return "hello , " + name;
	}

}
