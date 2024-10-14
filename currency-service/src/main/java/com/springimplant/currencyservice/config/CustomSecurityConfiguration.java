package com.springimplant.currencyservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@EnableWebSecurity
@Configuration
public class CustomSecurityConfiguration {
	
//	  @Autowired
//	  public void configure(AuthenticationManagerBuilder auth) throws Exception {
//	    auth
//	      .ldapAuthentication()
//	        .userDnPatterns("uid={0},ou=people")
//	        .groupSearchBase("ou=groups")
//	        .contextSource()
//	          .url("ldap://localhost:8389/dc=springframework,dc=org")
//	          .and()
//	        .passwordCompare()
//	          .passwordEncoder(new BCryptPasswordEncoder())
//	          .passwordAttribute("userPassword");
//	  }
	

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		SimpleUrlAuthenticationFailureHandler handler = new SimpleUrlAuthenticationFailureHandler("/");
        http.authorizeRequests(a -> a
                        .antMatchers("/", "/error", "/webjars/**","/api/v1/kafka/**","/actuator/**","/api/v1/home/**").permitAll()
                        .anyRequest().authenticated()
        )
        .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        )
        .csrf(c -> c.disable()
//        		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        		)
        .logout(l -> l
        		.logoutSuccessUrl("/").permitAll()
        		)
        .oauth2Login(o -> o
        		.failureHandler((request,response,exception) -> {
        			request.getSession().setAttribute("error.message", exception.getMessage());
        			handler.onAuthenticationFailure(request,response,exception);
        		})
        		);
        return http.build();
		
	}
}
