package com.shine.web;

import com.shine.web.websocket.RequestListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.annotation.Resource;

/**
 * Feign 使用暴露接口消费服务的方法
 * Feign 封装了 Ribbo + hystrix 同时也支持负载均衡 断路器
 * Feign 使用断路在yml文件设置开启
 * feign:
 *   hystrix:
 *      enabled: true
 * @author zhaitonghui
 *
 */
@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
//@ComponentScan(basePackages ="com.shine.web")
@ServletComponentScan
@EnableRedisHttpSession
public class ShineWebAppliction {

//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}
	public static void main(String[] args) {
		SpringApplication.run(ShineWebAppliction.class, args);
	}


//	@Autowired
//	private RequestListener requestListener;
//
//	@Bean
//	public ServletListenerRegistrationBean<RequestListener> servletListenerRegistrationBean() {
//		ServletListenerRegistrationBean<RequestListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
//		servletListenerRegistrationBean.setListener(requestListener);
//		return servletListenerRegistrationBean;
//	}
}