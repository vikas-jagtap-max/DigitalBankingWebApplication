package com.infymeMobile.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // This annotation is required for implementing role based authorization using
						// @PreAuthorize annotation
public class SecurityConfiguration {

	// Authorization using JWT

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	// As extending WebSecurityConfigurerAdapter class & overriding its configure
	// methods in SecurityCongiguration is deprecated in Spring Boot 3.x, hence we
	// use to defines which URLs in the application need to be authenticated.
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		// 1)Disables CSRF protection, typically needed for stateless APIs.
		// 2)Permits all requests to URLs matching requestMatchers("-")
		// 3)Requires authentication for all other requests.
		// 4)Configures a custom login form located at /login. The login page is a
		// simple HTML form.
		// 5)Uses jwtAuthenticationEntryPoint to handle unauthorized access attempts.
		// 6)Configures the session management to be stateless, suitable for REST APIs.
		// 7)Adds jwtAuthenticationFilter before the
		// UsernamePasswordAuthenticationFilter
		// to processs JWT tokens in the request headers of subsequent requests post
		// authentication.
		http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/infymemobile/security/register", "/infymemobile/security/validate")
						.permitAll().anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/infymemobile/security/authenticate").permitAll())
				.exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}

}
