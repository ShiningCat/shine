package com.shine.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shine.cm.service.TestService;

/**
 * GetMapping PostMapping PutMapping DeleteMapping
 * @GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。该注解将HTTP Get 映射到 特定的处理方法上。
 * RESTful API
 * GET /collection：返回资源对象的列表（数组）
 * GET /collection/resource：返回单个资源对象
 * POST /collection：返回新生成的资源对象
 * PUT /collection/resource：返回完整的资源对象
 * PATCH /collection/resource：返回完整的资源对象
 * DELETE /collection/resource：返回一个空文档
 */

@RestController
public class WebTestAction {
	
	@Autowired
	TestService service;
	@GetMapping(value = "/helloWorld")
	public String forHtml() throws InterruptedException{
//		Thread.sleep(5000L);
		return service.helloWorld();
	}

}
