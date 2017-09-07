package com.shine.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class WebTestController {


	@GetMapping("/member")
    public String consumer(HttpServletRequest request) {
//		ArrayList<String> list = new ArrayList<String>();
//		list.forEach(x -> System.out.print(x));
		String id = request.getSession().getId();
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		return "aaa" ;
	}



}
