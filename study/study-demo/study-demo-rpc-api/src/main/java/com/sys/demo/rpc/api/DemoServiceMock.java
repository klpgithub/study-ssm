package com.sys.demo.rpc.api;

/**
 * 降级实现DemoService接口
 * 
 * @author KLP
 * @date 2017年12月21日下午4:47:02
 */
public class DemoServiceMock implements DemoService {

	@Override
	public String sayHello(String name) {
		return null;
	}

}
