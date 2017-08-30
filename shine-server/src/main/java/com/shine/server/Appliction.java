package com.shine.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心,发现所有的服务
 * @author zhaitonghui
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class Appliction {
	public static void main(String[] args) {
		SpringApplication.run(Appliction.class, args);
	}
}