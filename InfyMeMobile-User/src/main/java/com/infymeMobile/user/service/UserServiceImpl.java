package com.infymeMobile.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infymeMobile.user.dto.LoggingDTO;
import com.infymeMobile.user.dto.UserDTO;
import com.infymeMobile.user.entity.LoggingEntity;
import com.infymeMobile.user.entity.UserEntity;
import com.infymeMobile.user.exception.InfyMeMobileGlobalHandlerException;
import com.infymeMobile.user.repository.LoggingRepository;
import com.infymeMobile.user.repository.UserRepository;

@Service(value = "UserService") // it marks the class as service provider
@Transactional /*
				 * if exception occurs previous method is revoked automatically only if the
				 * complete transaction/method is completed the data is stored or else it gets
				 * relled back without storing data.
				 */

public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userrepository;

	@Autowired
	public LoggingRepository loggingRepository;

	@Override
	public String createUser(UserDTO userDto) throws InfyMeMobileGlobalHandlerException {
		Optional<UserEntity> u1 = userrepository.findByMobileNumber(userDto.getMobileNumber());
		if (u1.isPresent()) {
			throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.USER_ALREADY_EXISTS");
		}

		UserEntity u2 = UserDTO.prepairEntity(userDto);
		u2 = userrepository.save(u2);
//		User u2= (x)->new userrepository.save(UserDTO().prepairEntity(x));
		// userDto.setMobileNumber(u2.getMobileNumber());
		String s1 = "The user has been registered with " + u2.getMobileNumber() + " and userId " + u2.getUserId();
		return s1;
	}

	@Override
	public Boolean loggingUser(LoggingDTO loggingDTO) throws InfyMeMobileGlobalHandlerException {
		String loginPassword = loggingDTO.getPassword(); // password extract from user input

//		Long loggingMobile = LoggingDTO.getMobileNumber();
//		User u1=userrepository.findByMobileNumber(loggingMobile);
//		exception handler
//		if(u1==null) {
//			throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.NO_USER_FOUND");
//		}
//		
//		    User u2=userrepository.findByPassword(loggingPassword);
//		    if(u2==null) {
//				throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.INVALID_PASSWORD");
//			}
//			// TODO Auto-generated method stub
//			return true;
//		String n=u1.getPassword();
//		if(loggingPassword == n) {
//			return true;
//		}
//		else {
//			return false;
//		}

		LoggingEntity u1 = loggingRepository.findByMobileNumber1(loggingDTO.getMobileNumber()); // checked if mobile
																								// number is present in
																								// database or not
		if (u1 == null) {
			throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.NO_USER_FOUND");
		}

		// String n=u1.getPassword();
		LoggingDTO ldto = LoggingDTO.prepareDTO(u1); // DATABASE MHADLA DATA DTO STORE
		String n = ldto.getPassword(); // DATABASE MHADLA PASSWORD STORED IN STRING
		if (loginPassword.equals(n)) { // COMPARED BOTH USER INPUT PASSWORD AND DATABASE PASSWORD
			return true;

		} else {
			throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.AUTHENTICATION_FAILED");
		}

	}

	@Override // Override method available in userService class
	public UserDTO getUserProfile(String userID) throws InfyMeMobileGlobalHandlerException {

		UserEntity u3 = userrepository.findById(userID);
		if (u3 == null) {
			throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.USERID_NOT_FOUND");
		}
//		User u4 = new User();
//		UserDTO udto1=new UserDTO();
		UserDTO udto1 = UserDTO.prepairDTO(u3);
		return udto1;
	}

	@Override
	public List<UserDTO> showAllUsers() throws InfyMeMobileGlobalHandlerException {

		List<UserEntity> List1 = userrepository.getAll();
		if (List1.isEmpty()) {
			throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.NO_USERS_FOUND");
		}
		List<UserDTO> list = new ArrayList<>();
//		for (User u1 : List1) {//for (Return_Type localvariable:input)
//			UserDTO udto = UserDTO.prepairDTO(ul);
//			list.add(udto)
//			
//		}
		List1.stream().forEach(x -> list.add(new UserDTO().prepairDTO(x)));
		return list;
	}

}
