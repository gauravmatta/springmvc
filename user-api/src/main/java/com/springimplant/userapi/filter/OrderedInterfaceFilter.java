package com.springimplant.userapi.filter;

import java.io.IOException;
import java.util.Collections;

import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderedInterfaceFilter extends OncePerRequestFilter implements OrderedFilter {
	
	private final ApplicationContext applicationContext;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Collections.list(request.getHeaderNames()).forEach(header -> 
		log.info("Header from Ordered Interface Filter: "+header+request.getHeader(header))
	);
		filterChain.doFilter(request, response);
	}

	@Override
	public int getOrder() {
		if(applicationContext.containsBean("headersLoggingFilter")) {
			return -1;	
		}
		return Integer.MAX_VALUE;
	}
}
