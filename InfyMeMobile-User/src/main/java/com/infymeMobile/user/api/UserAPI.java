package com.infymeMobile.user.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infymeMobile.user.dto.LoggingDTO;
import com.infymeMobile.user.dto.UserDTO;
import com.infymeMobile.user.exception.InfyMeMobileGlobalHandlerException;
import com.infymeMobile.user.service.UserService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@RestController // class level annotation to define the class as controller
@RequestMapping(value = "/infymemobile/user") // Defines the base URL of the project
@Validated
public class UserAPI {

	@Autowired // Enables dependency injections
	public UserService userService;

	@PostMapping(value = "/users") // Defines the URL of the posting data
	ResponseEntity<String> createdUser(@RequestBody // Validate where body is available with data or not
	@Valid // Validates body based on different conditions such as length,pattern,etc
	UserDTO userDTO) throws InfyMeMobileGlobalHandlerException {
		String udto = userService.createUser(userDTO);
		return new ResponseEntity<>(udto, HttpStatus.CREATED);

	}

	@PostMapping(value = "/users/login")
	ResponseEntity<Boolean> loginUser(@RequestBody @Valid LoggingDTO loginDTO)
			throws InfyMeMobileGlobalHandlerException {
		Boolean ldto = userService.loggingUser(loginDTO);
		return new ResponseEntity<>(ldto, HttpStatus.CREATED);
	}

	@GetMapping(value = "/users/{userId}") // Defines the URL of the retrieving data
	ResponseEntity<UserDTO> getUserProfile(@PathVariable // tells that the path required a value which is inside {} in
															// URL.
	@Pattern(regexp = "[U] {1} [A-Za-z0-9]+", message = "{user.userid.invalid}") // Pattern used for userID
	String userId) throws InfyMeMobileGlobalHandlerException {

		UserDTO ul = userService.getUserProfile(userId);
		return new ResponseEntity<>(ul, HttpStatus.OK);
	}

	@GetMapping(value = "/users/all") // Defines the URL of the retrieving data
	ResponseEntity<List<UserDTO>> showAllUsers() throws InfyMeMobileGlobalHandlerException {
		List<UserDTO> u = userService.showAllUsers();
		return new ResponseEntity<>(u, HttpStatus.OK);
	}

}
