package com.springimplant.jwt.api.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springimplant.jwt.api.service.impl.CustomUserDetailServiceImpl;
import com.springimplant.jwt.api.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private CustomUserDetailServiceImpl customUserDetailService;

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
	
	
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
	    List<AntPathRequestMatcher> excludedMatchers = Arrays.asList(new AntPathRequestMatcher("/login"));
	    return excludedMatchers.stream()
                .anyMatch(matcher -> matcher.matches(request));
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