package com.shine.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * http://localhost:8989/turbine.stream
 */
@EnableTurbine
@SpringBootApplication
public class ShineTurbineApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ShineTurbineApplication.class, args);
	}
}
