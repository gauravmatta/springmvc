package com.springimplant.votingsystem.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springimplant.votingsystem.config.UniqueIdFilterConfiguration;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Component
@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
public class UniqueIdFilter extends OncePerRequestFilter {

	private final String responseHeader;
	private final String mdcKey;
	private final String requestHeader;
	private final String authHeader;
	
	public UniqueIdFilter(String authHeader,String responseHeader, String mdcKey, String requestHeader) {
		super();
		this.authHeader = authHeader;
		this.responseHeader = responseHeader;
		this.mdcKey = mdcKey;
		this.requestHeader = requestHeader;
	}
	
	@Autowired
	public UniqueIdFilter() {
		super();
		authHeader=UniqueIdFilterConfiguration.AUTHRIZATION_STRING_TOKEN;
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
		
		String authToken = null;
		if(hasAuthorizationHeader(request)) {
			authToken=getAccessToken(request);
			response.addHeader(authHeader, authToken);
			setAuthenticationContext(authToken,request);	
		}
		
		
		filterChain.doFilter(request,response);
		
		
		} finally {
			MDC.remove(mdcKey);
		}
	}
	
	private void setAuthenticationContext(String token,HttpServletRequest request) {
//		String username=jwtUtil.extractUsername(token);
//		if(username!=null && SecurityContextHolder.getContext().getAuthentication() == null) {
//			UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
//			log.info("User Details: "+ userDetails);
//			if(Boolean.TRUE.equals(jwtUtil.validateToken(token, userDetails))) {
//				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
//				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//			}
//		}
	}
	
	private String getAccessToken(HttpServletRequest request) {
		String authrizationHeaderString = request.getHeader("Authorization");
		log.info("Authorization Token: "+ authrizationHeaderString.split(" ")[1].trim());
		return authrizationHeaderString.substring(7);
	}
	
	private boolean hasAuthorizationHeader(HttpServletRequest request) {
		String authrizationHeaderString = request.getHeader("Authorization");
		log.info("Authorization header: "+ authrizationHeaderString);
		return !ObjectUtils.isEmpty(authrizationHeaderString) && authrizationHeaderString.startsWith("Bearer ");
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
