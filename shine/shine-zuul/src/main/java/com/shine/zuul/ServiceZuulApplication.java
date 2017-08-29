package com.shine.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.netflix.zuul.ZuulFilter;

/**
 * zuul主要作用是请求转发，和过滤，请求转发是做了负载均衡。
 * 我的理解是zuul也需要做一次集群，因为 zuul是网关，可能需要做很复杂的逻辑，比如查数据库，还有静态资源.
 * 在最外一层需要再一个zuul或者nginx去路由。
 * @author zhaitonghui
 *
 */
@SpringCloudApplication
@EnableZuulProxy
public class ServiceZuulApplication {

	
	@Bean
    public ZuulFilter gatewayFilter() {
        return new GatewayFilter();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceZuulApplication.class, args);
	}
}
