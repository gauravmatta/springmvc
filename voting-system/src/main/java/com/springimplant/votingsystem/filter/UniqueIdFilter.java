package com.springimplant.votingsystem.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springimplant.votingsystem.config.UniqueIdFilterConfiguration;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Component
@Data
@EqualsAndHashCode(callSuper = false)
public class UniqueIdFilter extends OncePerRequestFilter {

	private final String responseHeader;
	private final String mdcKey;
	private final String requestHeader;
	
	public UniqueIdFilter(String responseHeader, String mdcKey, String requestHeader) {
		super();
		this.responseHeader = responseHeader;
		this.mdcKey = mdcKey;
		this.requestHeader = requestHeader;
	}
	
	public UniqueIdFilter() {
		super();
		responseHeader=UniqueIdFilterConfiguration.DEFAULT_HEADER_TOKEN;
		mdcKey=UniqueIdFilterConfiguration.DEFAULT_MDC_UUID_TOKEN_KEY;
		requestHeader=UniqueIdFilterConfiguration.DEFAULT_HEADER_TOKEN;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
		final String token = extractToken(request);
		MDC.put(mdcKey, token);
		if(StringUtils.hasText(responseHeader)) {
			response.addHeader(responseHeader, token);
		}
		filterChain.doFilter(request,response);
		} finally {
			MDC.remove(mdcKey);
		}
	}
	
	private String extractToken(final HttpServletRequest request) {
		final String token;
		if(StringUtils.hasText(requestHeader) && StringUtils.hasText(request.getHeader(requestHeader))) {
			token= request.getHeader(requestHeader);
		} else {
			token=UUID.randomUUID().toString().toUpperCase().replace("-","");
		}
		return token;
	}

	@Override
	protected boolean isAsyncDispatch(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.isAsyncDispatch(request);
	}

	@Override
	protected boolean shouldNotFilterErrorDispatch() {
		// TODO Auto-generated method stub
		return super.shouldNotFilterErrorDispatch();
	}
}
