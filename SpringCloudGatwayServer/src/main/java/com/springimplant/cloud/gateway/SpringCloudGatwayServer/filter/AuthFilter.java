package com.springimplant.cloud.gateway.SpringCloudGatwayServer.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;

import com.springimplant.cloud.gateway.SpringCloudGatwayServer.config.RedisHashComponent;
import com.springimplant.cloud.gateway.SpringCloudGatwayServer.dto.ApiKey;
import com.springimplant.cloud.gateway.SpringCloudGatwayServer.util.AppConstants;
import com.springimplant.cloud.gateway.SpringCloudGatwayServer.util.MapperUtils;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class AuthFilter implements GlobalFilter,Ordered {
	
	@Autowired
	private RedisHashComponent redisHashComponent;
	
	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		List<String> apiKeysHeader=exchange.getRequest().getHeaders().get("gatewaykey");
		log.info("api key {}",apiKeysHeader);
		Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
		String routeID=route!=null?route.getId():null;
		if(routeID==null || CollectionUtils.isEmpty(apiKeysHeader) || !isAuthorize(routeID,apiKeysHeader.get(0))) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"you can't consume this service, Please validate your api keys");
		}
		return chain.filter(exchange);
	}
	
	private boolean isAuthorize(String routeId,String apiKey) {
		Object apiKeyObject= redisHashComponent.hGet(AppConstants.RECORD_KEY, apiKey);
		if(apiKeyObject!=null) {
			ApiKey key = MapperUtils.objectMapper(apiKeyObject, ApiKey.class);
			return key.getServices().contains(routeId);
		} else {
			return false;
		}
	}

	
}
