package com.shine.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shine.cm.service.TestService;

@RestController
public class WebTestAction {
	
	@Autowired
	TestService service;
	@RequestMapping(value = "/helloWorld")
	public String forHtml() throws InterruptedException{
//		Thread.sleep(5000L);
		return service.helloWorld();
	}
}
