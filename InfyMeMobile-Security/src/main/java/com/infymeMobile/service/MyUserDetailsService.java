package com.infymeMobile.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infymeMobile.entity.User;
import com.infymeMobile.repository.UserRepository;

//UserDetailsService, an inbuilt interface that is used to load user details from the database
//Hence we have provided its custom implementation here
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	// here's a circular dependency formed between your ApplicationConfiguration and
	// MyUserDetailsService. hence, use Use Constructor Injection
	private PasswordEncoder passwordEncoder;

	public MyUserDetailsService(@Lazy PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	//
	public String saveUser(User usr) {
		//
		usr.setPassword(passwordEncoder.encode(usr.getPassword()));
		//
		userRepository.save(usr);
		return "User registered successfully";
	}

	//
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// We pass username coming in the login/Authentication request over here, and
		// get the User Entity object based on it. using it form the custom User which
		// contains database username and password
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		// Convert your fetched object of MyUserDetailsService into Inbuilt UserDetails
		// Object
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

}