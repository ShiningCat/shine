package com.shine.web;


import com.shine.web.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

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
@ServletComponentScan
public class ShineWebAppliction {

	public static void main(String[] args) {
		SpringApplication.run(ShineWebAppliction.class, args);
	}

	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new CorsFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("paramName", "paramValue");
		registration.setName("CorsFilter");
		registration.setOrder(1);
		return registration;
	}
}