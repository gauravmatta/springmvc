package com.springimplant.votingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.springframework.security.config.Customizer.withDefaults;
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("springimplant")
		.password("springimplant")
		.roles("USER")
		.and()
		.withUser("gaurav")
		.password("gaurav")
		.roles("ADMIN");
	}
	
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		try {
			http.authorizeHttpRequests()
			.antMatchers("/election/admin").hasRole("ADMIN")
					.antMatchers("/","static/css","static/js").permitAll()
                    .antMatchers("/election/user").hasAnyRole("USER","ADMIN")
                    .and().formLogin(withDefaults())
                 .formLogin(login->login.loginPage("/login").permitAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Bean
    PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	

}
