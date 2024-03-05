package com.infymeMobile.user.dto;

import com.infymeMobile.user.entity.LoggingEntity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class LoggingDTO {

	@NotNull(message = "{user.mobilenumber.notpresent}") // Value should always be present
	@Digits(fraction = 0, integer = 10, message = "{user.mobilenumber.invalid}") // pattern used for mobile number
	private Long mobileNumber;

	@NotNull(message = "{user.mobilenumber.notpresent}") // Value should always be present
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$_])(?=\\$=$).{5,10}$", message = "{user.password.invalid")
	private String password;

	/**
	 * @return the mobileNumber
	 */
	public Long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [mobileNumber=" + mobileNumber + ",password=" + password + "]";
	}

	public static LoggingDTO prepareDTO(LoggingEntity l) {
		LoggingDTO ldto = new LoggingDTO();
		ldto.setMobileNumber(l.getMobileNumber());
		ldto.setPassword(l.getPassword());
		return ldto;
	}

}
