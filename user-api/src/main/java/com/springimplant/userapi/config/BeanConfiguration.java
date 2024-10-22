package com.springimplant.userapi.config;

import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

import com.springimplant.userapi.filter.BeanRegisteredFilter;
import com.springimplant.userapi.service.impl.MyUserDetailsService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class BeanConfiguration {
	
	MyUserDetailsService userdetailsService;
	
	ApplicationContext applicationContext;
    
	@Bean
    RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
    UserDetailsManager users(@Qualifier("postgresDataSource") DataSource dataSource) {		
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery("select username,password,enabled from users where username = ?");
        users.setAuthoritiesByUsernameQuery("select username,authority from authorities where username = ?");
        return users;
    }
	
	@Bean
    AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userdetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http
		 .csrf(csrf->csrf.disable())
		 .authorizeHttpRequests(authz ->
			 authz
			 .requestMatchers("/admin").hasRole("ADMIN")
			 .requestMatchers("/user").hasAnyRole("ADMIN","USER")
			 .requestMatchers("/home").permitAll()
			 .requestMatchers("/").permitAll()
			 .anyRequest().authenticated())
		 .formLogin(form->form.permitAll());
     return http.build();
	}
	
	@Bean
	FilterRegistrationBean<BeanRegisteredFilter> myCustomBeanFilterRegistration(BeanRegisteredFilter filter){
	final FilterRegistrationBean<BeanRegisteredFilter> registrationBean = new FilterRegistrationBean<BeanRegisteredFilter>(filter);
	if(applicationContext.containsBean("beanRegisteredFilter")) {
	registrationBean.setOrder(3);
	registrationBean.setName("beanFilter");
	registrationBean.setUrlPatterns(Collections.singletonList("/user/*"));
	}else {
		registrationBean.setOrder(Integer.MAX_VALUE);
	}
	return registrationBean;
	}
}
