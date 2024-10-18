package com.springimplant.jwt.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springimplant.jwt.api.filter.JwtFilter;
import com.springimplant.jwt.api.service.impl.CustomUserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		prePostEnabled = false,
		securedEnabled = false,
		jsr250Enabled = true
		)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailServiceImpl userDetailService;
	
	@Autowired
	private JwtFilter filter;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	}
	
	@Bean(name= BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


    /**
     * The default prefix used with role based authorization. Default is "ROLE_".
     * change the default role prefix
     */
    @Bean
    static GrantedAuthorityDefaults grantedAuthorityDefaults() {
		return new GrantedAuthorityDefaults("");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable());
//        http.authorizeRequests(requests -> requests.antMatchers("/authenticate","/login").permitAll()
//                .anyRequest().authenticated())
//                .exceptionHandling(handling -> handling.authenticationEntryPoint(((request, response, authException) -> {
//                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//                    authException.getMessage();
//                })))
//                .formLogin(login -> login.permitAll())
//                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
//	}
}
