package com.infymeMobile.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//JWT Token Generation post successful auth and Validation when it comes from request header for subsequent requests
@Component
public class JwtUtil {

	private String SECRET_KEY = "secret";

	//
	public String extractUsernameFromJwtToken(String token) {
		return extractClaimFromJwtToken(token, Claims::getSubject);
	}

	//
	public Date extractExpirationFromJwtToken(String token) {
		return extractClaimFromJwtToken(token, Claims::getExpiration);
	}

	//
	public <T> T extractClaimFromJwtToken(String token, Function<Claims, T> ClaimsResolver) {
		final Claims claims = extractAllClaimsFromJwtToken(token);
		return ClaimsResolver.apply(claims);
	}

	// For retrieving any information from JWT token we will need the secret key
	private Claims extractAllClaimsFromJwtToken(String token) {
		return Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).getBody();
	}

	// Check if the JWT token has expired
	private Boolean isTokenExpired(String token) {
		return extractExpirationFromJwtToken(token).before(new Date());
	}

	// Generate JWT token for User
	public String generateJwtToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());
	}

	private String createToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	// Validate JWT Token when it comes from request header for subsequent requests
	public Boolean validateJwtToken(String token, UserDetails userDetails) {
		final String username = extractUsernameFromJwtToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}
