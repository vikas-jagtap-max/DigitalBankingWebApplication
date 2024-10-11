package com.infymeMobile.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.net.HttpHeaders;

@Component
public class JwtAuthenticationFilter extends AbstractGatewayFilterFactory<JwtAuthenticationFilter.Config> {

	@Autowired
	private RouteValidator routeValidator;

	@Autowired
	private RestTemplate restTemplate;

	public JwtAuthenticationFilter() {
		super(Config.class);

	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) -> {

			if (routeValidator.isSecured.test(exchange.getRequest())) {

				// Check whether request header contains JWT token or not
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("Missing Authorization Header");
				}

				// If contains
				String authorizationHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);

				// Extracting the JWT token from the Header. As it always starts with Bearer and
				// contains 7 void spaces.
				if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
					String jwtToken = authorizationHeader.substring(7);

					// Simply give a synchronous call using RestTemplate to security microservice
					// for validating the extracted JWT token
					try {
						// As we implemented service registry and discovery in API gateway as well, no
						// need to give hostname & port of security microservice.

						restTemplate.getForObject("http://security-microservice/validate?token=" + jwtToken,
								String.class);

					} catch (Exception e) {
						throw new RuntimeException("Failed to validate JWT token or unauthorized access");

					}

				}

			}
			return chain.filter(exchange);
		});
	}

	public static class Config {

	}

}
