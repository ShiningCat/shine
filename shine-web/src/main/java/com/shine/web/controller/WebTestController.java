package com.shine.web.controller;

import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.shine.web.feign.WebTestService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;


@RestController
public class WebTestController {

	@Autowired
	WebTestService service;
	
//	@GetMapping("/consumer")
//    public TMemUserLoginBean consumer(HttpServletRequest request) {
////		ArrayList<String> list = new ArrayList<String>();
////		list.forEach(x -> System.out.print(x));
////		String id = request.getSession().getId();
////		System.out.println(id);
////		System.out.println(id);
////		System.out.println(id);
////		System.out.println(id);
////		System.out.print(service.consumer());
//		return service.consumer();
//    }

	@GetMapping( value = "/login",params = "error")
	public String logine() {
		String s = HtmlUtils.htmlEscape("<div>hello world</div><p>&nbsp;</p>");
		System.out.println(s);
		String s2 = HtmlUtils.htmlUnescape(s);
		System.out.println(s2);
		return "logint error";
	}

	@GetMapping( value = "/login")
	public String login(HttpServletRequest request) {
		String sessionId = request.getSession().getId();
		System.out.println(sessionId);
		System.out.println(sessionId);
		System.out.println(sessionId);
		return "11";
	}

//	@Secured({"ROLE_ADMIN","ROLE_USER"})//此方法只允许 ROLE_ADMIN 和ROLE_USER 角色 访问
	@GetMapping("/home")
	public String home() {
		return "login success";
	}



}
