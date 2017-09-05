package com.shine.web.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.shine.web.fallbark.HystrixClientFallback;


/**
 * @FeignClient 绑定該接口到shine-service服务，并通知Feign组件对该接口进行代理(并不需要实现具体接口)
 * 
 * 注意 Feign的Hystrix支持 需要实现接口  fallback = xxx.class 该类实现所有接口短路后方法
 * @author zhaitonghui
 *
 */
@FeignClient(value = "shine-service", fallback = HystrixClientFallback.class)
public interface WebTestService {
	
	/**
	 * 有人说在 @FeignClient 注解的接口不可以使用 @GetMapping 这种组合注解
	 * 具体不确定
	 * http://blog.csdn.net/xinluke/article/details/76146221
	 * @return
	 */
    @GetMapping(value = "/helloWorld")
    String consumer();
}