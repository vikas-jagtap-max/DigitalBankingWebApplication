package com.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infymeMobile.entity.User;
import com.infymeMobile.model.AuthenticationRequest;
import com.infymeMobile.model.AuthenticationResponse;
import com.infymeMobile.security.JwtUtil;
import com.infymeMobile.service.MyUserDetailsService;

@RestController
@RequestMapping("/infymemobile/security")
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService MyUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserDetails userDetails;

	// Registration of User
	@PostMapping("/register")
	public String register(@RequestBody User user) {

		return MyUserDetailsService.saveUser(user);
	}

	// Login/Authentication of User
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationTokenUponLogin(
			@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		//
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password", e);
		}

		// Authentication Manager can't directly talk to DB so we use UserDetails to
		// talk to DB
		userDetails = MyUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		// Simply we are taking the username and password from the incoming
		// authentication request and check incoming
		// username and password is matching against the database username and password.

		final String jwtToken = jwtUtil.generateJwtToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwtToken));

	}

	// Validating the JWT token coming in header of every subsequent request post
	// authentication
	@GetMapping("/validate")
	public String verifyToken(@RequestParam("token") String token) {
		jwtUtil.validateJwtToken(token, userDetails);
		return "Token is Valid";

	}

}
