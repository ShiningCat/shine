package com.shine.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hystrix监控面板
 * 实时监控 服务提供者 和 服务消费者 数据流量访问情况
 * 监控单实例节点需要通过访问实例的/hystrix.stream接口来实现
 * Delay：该参数用来控制服务器上轮询监控信息的延迟时间，默认为2000毫秒，我们可以通过配置该属性来降低客户端的网络和CPU消耗。
 * Title：该参数对应了上图头部标题Hystrix Stream之后的内容，默认会使用具体监控实例的URL，我们可以通过配置该信息来展示更合适的标题。
 * 实心圆：共有两种含义。它通过颜色的变化代表了实例的健康程度，如下图所示，它的健康度从绿色、黄色、橙色、红色递减。该实心圆除了颜色的变化之外，它的大小也会根据实例的请求流量发生变化，流量越大该实心圆就越大。所以通过该实心圆的展示，我们就可以在大量的实例中快速的发现故障实例和高压力实例。
 * 曲线：用来记录2分钟内流量的相对变化，我们可以通过它来观察到流量的上升和下降趋势。
 * http://blog.didispace.com/spring-cloud-starter-dalston-5-1/#lg=1&slide=3
 *
 * http://localhost:5000/hystrix
 * http://localhost:2002/hystrix.stream : shine-web
 * @author zhaitonghui
 *
 */
@EnableHystrixDashboard
@SpringBootApplication
public class ShineHystrixDashboardApplication {   

	public static void main(String[] args) {
		SpringApplication.run(ShineHystrixDashboardApplication.class, args);
	}
}
