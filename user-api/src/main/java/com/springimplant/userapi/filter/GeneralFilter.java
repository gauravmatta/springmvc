package com.springimplant.userapi.filter;

import java.io.IOException;
import java.util.Collections;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(2)
public class GeneralFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Collections.list(request.getHeaderNames()).forEach(header -> 
		log.info("Header from General Filter: "+header+request.getHeader(header))
	);
		filterChain.doFilter(request, response);
	}
}
