package com.shine.web.fallbark;

import org.springframework.stereotype.Component;

import com.shine.web.service.WebTestService;

/**
 * service 调用失败后,执行熔断方法
 */
@Component
public class HystrixClientFallback implements WebTestService{

	@Override
	public String consumer() {
		return "service : 500";
	}

}
