package com.shine.web.fallbark;

import org.springframework.stereotype.Component;

import com.shine.web.feign.WebTestService;

/**
 * service 调用失败后,执行熔断方法
 */
@Component
public class HystrixClientFallback implements WebTestService{

//	@Override
//	public TMemUserLoginBean consumer() {
//		return new  TMemUserLoginBean();
//	}

}
