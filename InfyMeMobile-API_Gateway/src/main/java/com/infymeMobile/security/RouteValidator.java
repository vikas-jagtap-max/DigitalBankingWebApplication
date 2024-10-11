package com.infymeMobile.security;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {

	// Skipping below URLs of authentication from being hindered in API gateway also
	public static final List<String> openApiEndpoints = List.of("/infymemobile/security/register",
			"/infymemobile/security/authenticate", "/eureka");

	public Predicate<ServerHttpRequest> isSecured = request -> openApiEndpoints.stream()
			.noneMatch(uri -> request.getURI().getPath().equals(uri));
}
