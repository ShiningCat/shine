package com.shine.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shine.web.service.WebTestService;

import java.util.ArrayList;
import java.util.List;


@RestController
public class WebTestController {

	@Autowired
	WebTestService service;
	
	@GetMapping("/consumer")
    public String consumer() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("cc");
		list.forEach(x -> System.out.print(x));
		return service.consumer();
    }
}
