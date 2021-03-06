package com.shine.forum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 通过 @EnableEurekaClient 注解，为服务提供方赋予注册和发现服务的能力
 * 
 * SpringCLoud中的"Discovery Service"有多种实现，比如：eureka, consul, zookeeper。
 * 1，@EnableDiscoveryClient注解是基于spring-cloud-commons依赖，并且在classpath中实现； 
 * 2，@EnableEurekaClient注解是基于spring-cloud-netflix依赖，只能为eureka作用；
 * 如果你的classpath中添加了eureka，则它们的作用是一样的。
 * 
 * @author zhaitonghui
 *
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableTransactionManagement
@MapperScan("com.shine.forum.mapper")
public class ForumServiceAppliction {

	public static void main(String[] args) {
		SpringApplication.run(ForumServiceAppliction.class, args);
	}

}