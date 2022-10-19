package com.springimplant.jwt.api.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springimplant.jwt.api.service.CustomUserDetailService;
import com.springimplant.jwt.api.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = null;
		if(hasAuthorizationHeader(request)) {
			token=getAccessToken(request);
			setAuthenticationContext(token,request);	
		}
		filterChain.doFilter(request, response);
	}
	
	private void setAuthenticationContext(String token,HttpServletRequest request) {
		String username=jwtUtil.extractUsername(token);
		if(username!=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
			log.info("User Details: "+ userDetails);
			if(Boolean.TRUE.equals(jwtUtil.validateToken(token, userDetails))) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
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
	
	
}