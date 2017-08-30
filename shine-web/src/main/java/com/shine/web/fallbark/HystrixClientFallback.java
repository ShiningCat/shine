package com.shine.web.fallbark;

import org.springframework.stereotype.Component;

import com.shine.web.service.WebTestService;

@Component
public class HystrixClientFallback implements WebTestService{

	@Override
	public String consumer() {
		return "service : 500";
	}

}
