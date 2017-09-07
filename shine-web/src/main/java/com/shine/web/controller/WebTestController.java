package com.shine.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shine.web.service.WebTestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class WebTestController {

	@Autowired
	WebTestService service;
	
	@GetMapping("/consumer")
    public String consumer(HttpServletRequest request) {
//		ArrayList<String> list = new ArrayList<String>();
//		list.forEach(x -> System.out.print(x));
		String id = request.getSession().getId();
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		System.out.println(id);
		return service.consumer();
    }



}
