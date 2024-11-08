package com.springimplant.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.springimplant.gatewayservice.constants.AppConstants;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableDiscoveryClient
public class GatewayserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserviceApplication.class, args);
	}

//    @Bean
//    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route(AppConstants.STUDENT_SERVICE_KEY,r->r.path("/api/student/**")
//				.filters(f->f.stripPrefix(2)).uri("http://localhost:8003"))
//				.route(AppConstants.COURSE_SERVICE_KEY,r->r.path("/api/course/**")
//				.filters(f->f.stripPrefix(2)).uri("http://localhost:8002"))
//				.route(AppConstants.COURSE_SERVICE_KEY,r->r.path("/api/users/**")
//						.filters(f->f.stripPrefix(2)).uri("http://localhost:8003"))
//				.route(AppConstants.AUTH_SERVICE_KEY,r->r.path("/api/semauth/**")
//						.filters(f->f.stripPrefix(2)).uri("http://localhost:8081"))
//				.build();
//	}
}
