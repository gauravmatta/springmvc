package com.springimplant.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
// To Enable OAuth
//@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication()
    	.withUser("gaurav")
    	.password("12345")
    	.roles("USER")
    	.and()
    	.withUser("userTest")
    	.password("test")
    	.roles("ADMIN");
	}

	@Bean
    AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> {
			try {
				csrf.disable()
				    .authorizeRequests(requests -> requests.antMatchers("/login").permitAll()
				    		.anyRequest().authenticated());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		})
        .formLogin(login -> login
                     .loginPage("/home/login").permitAll())
	    .logout(logout -> logout.invalidateHttpSession(true)
	                .clearAuthentication(true)
	                .logoutRequestMatcher(new AntPathRequestMatcher("/home/logout"))
	                .logoutSuccessUrl("/home/logout-success").permitAll());
	}


	
	
	
// Hardcode UserName and Password for Testing Purposes	
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("SpringImplant").password("1234").roles("USER").build());
//		return new InMemoryUserDetailsManager(users);
//	}
	
	
}
