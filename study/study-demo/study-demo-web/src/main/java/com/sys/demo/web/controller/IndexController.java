package com.sys.demo.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.common.base.BaseController;
import com.sys.demo.rpc.api.DemoService;
import com.sys.demo.web.model.User;

/**
 * 测试controller
 * 
 * @author KLP
 * @date 2017年12月21日下午5:25:39
 */
@Controller
public class IndexController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private DemoService demoService;

	@RequestMapping(value = "/jsp", method = RequestMethod.GET)
	public String jsp(Model model) {
		model.addAttribute("demo", demoService.sayHello("jetty"));
		return jsp("/index");
	}

	@RequestMapping(value = "/thymeleaf", method = RequestMethod.GET)
	public String thymeleaf(Model model) {
		model.addAttribute("host", demoService.sayHello("www.sys.com"));
		List<User> list = new ArrayList<User>();
		User user = new User(1, "张三", "2015");
		list.add(user);
		model.addAttribute("users", list);
		return thymeleaf("/index");
	}

}
