package com.demo.prime.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public AppUserDetailsService userDetailsService(BCryptPasswordEncoder passwordEncoder) {
		return new AppUserDetailsService(passwordEncoder);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			
		http
		.csrf().disable()
		.headers().frameOptions().sameOrigin()
		.and()
		
		.authorizeRequests()
			.antMatchers("/Login.xhtml", "/Error.xhtml", "/javax.faces.resource/**").permitAll()
			.antMatchers("/Inicio.xhtml").authenticated()
			.and()
		
		.formLogin()
			.loginPage("/Login.xhtml")
			.failureUrl("/Login.xhtml?invalid=true")
			.and()
		
		.logout()
			.logoutSuccessUrl("/Login.xhtml")
			.and()
        .exceptionHandling().accessDeniedPage("/Error.xhtml");
	
	}
}
