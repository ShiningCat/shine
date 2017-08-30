package com.shine.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shine.web.service.WebTestService;


@RestController
public class WebTestController {

	@Autowired
	WebTestService service;
	
	@GetMapping("/consumer")
    public String consumer() {
		return service.consumer();
    }
}
