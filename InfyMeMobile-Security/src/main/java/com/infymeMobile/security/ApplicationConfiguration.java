package com.infymeMobile.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.infymeMobile.service.MyUserDetailsService;

//Authentication using spring security
@Configuration
public class ApplicationConfiguration {

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	//
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
	}

	// Spring Security 5.x allows password storage only in a secure way using
	// hashing
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {

		return builder.getAuthenticationManager();
	}
}
