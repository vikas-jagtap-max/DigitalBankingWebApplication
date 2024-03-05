package com.infymeMobile.user.service;

import java.util.List;

import com.infymeMobile.user.dto.LoggingDTO;
import com.infymeMobile.user.dto.UserDTO;
import com.infymeMobile.user.exception.InfyMeMobileGlobalHandlerException;

public interface UserService {

	public String createUser(UserDTO userDto) throws InfyMeMobileGlobalHandlerException; 
	
	public Boolean loggingUser(LoggingDTO loginDto) throws InfyMeMobileGlobalHandlerException; 
	
	public UserDTO getUserProfile(String userDto) throws InfyMeMobileGlobalHandlerException; 
	
	List<UserDTO> showAllUsers() throws InfyMeMobileGlobalHandlerException;
		

}
