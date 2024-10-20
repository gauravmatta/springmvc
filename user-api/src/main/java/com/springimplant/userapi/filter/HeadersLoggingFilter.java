package com.springimplant.userapi.filter;

import java.io.IOException;
import java.util.Collections;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(1)
public class HeadersLoggingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		Collections.list(httpServletRequest.getHeaderNames()).forEach(header -> 
			log.info("Header from Headers Filter: "+header+httpServletRequest.getHeader(header))
		);
		chain.doFilter(request, response);
	}
}
