package com.infymeMobile.user.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infymeMobile.user.entity.UserEntity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO {

	@NotNull(message = "{user.mobilenumber.notpresent}")
	@Digits(fraction = 0, integer = 10, message = "{user.mobilenumber.invalid}")
	private Long mobileNumber;

	@NotNull(message = "{user.userid.notpresent}")
	@Pattern(regexp = "([U][A-Za-z0-9]+)", message = "{user.userid.invalid}")
	private String userId;

	@NotNull(message = "{user.accountholdername.notpresent}")
	// @Min(value = 3, message = "{user.accountholdername.invalid}")
	// @Max(value = 50, message = "{user.accountholdername.invalid}")
	@Size(min = 3, max = 50, message = "{user.accountholdername.invalid}")
	private String accountHolderName;

	@NotNull(message = "{user.gender.notpresent}")
	@Pattern(regexp = "(Male/Female)", message = "{user.gender.invalid}")
	private String gender;

	@NotNull(message = "{user.dateofbirth.notpresent}")
	@Past(message = "{user.dateofbirth.invalid}")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateOfBirth;

	@NotNull(message = "{user.password.notpresent}")
	// @Min(value = 3, message = "{user.password.invalid}")
	// @Max(value = 50, message = "{user.password.invalid}")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[]@#$_)(?=\\S+$).{5,10}$", message = " user.password.invalid")
	private String password;

	@NotNull(message = "{user.email.notpresent}")
	@Pattern(regexp = "([a-zA-Z0-9._]+)@(infosys|gmail|yahoo.com)", message = "user.email.invalid")
	private String email;

	@NotNull(message = "{user.communicationaddress.notpresent}")
	// @Min(value = 3, message = "{user.communicationaddress.invalid}")
	// @Max(value = 50, message = "{user.communicationaddress.invalid}")
	@Size(min = 3, max = 50, message = "{user.communicationaddress.invalid}")
	private String communicationAddress;

	@NotNull(message = "{user.pan.notpresent}")
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}", message = "{user.pan.invalid}")
	private String pan;

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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the accountHolderName
	 */
	public String getAccountHolderName() {
		return accountHolderName;
	}

	/**
	 * @param accountHolderName the accountHolderName to set
	 */
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the communicationAddress
	 */
	public String getCommunicationAddress() {
		return communicationAddress;
	}

	/**
	 * @param communicationAddress the communicationAddress to set
	 */
	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}

	/**
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}

	/**
	 * @param pan the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
	}

	@Override
	public String toString() {
		return "UserDTO [mobileNumber=" + mobileNumber + ", userId=" + userId + ", accountHolderName="
				+ accountHolderName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", password=" + password
				+ ", email=" + email + ", communicationAddress=" + communicationAddress + ", pan=" + pan + "]";
	}

	public static UserEntity prepairEntity(UserDTO userDTO) {
		UserEntity ul = new UserEntity();

		ul.setUserId(userDTO.getUserId());
		ul.setMobileNumber(userDTO.getMobileNumber());
		ul.setAccountHolderName(userDTO.getAccountHolderName());
		ul.setCommunicationAddress(userDTO.getCommunicationAddress());
		ul.setDateofbirth(userDTO.getDateOfBirth());
		ul.setEmail(userDTO.getEmail());
		ul.setGender(userDTO.getGender());
		ul.setPan(userDTO.getPan());
		ul.setPassword(userDTO.getPassword());
		return ul;
	}

	public static UserDTO prepairDTO(UserEntity userEntity) {
		UserDTO udto = new UserDTO();

		udto.setUserId(userEntity.getUserId());
		udto.setMobileNumber(userEntity.getMobileNumber());
		udto.setAccountHolderName(userEntity.getAccountHolderName());
		udto.setCommunicationAddress(userEntity.getCommunicationAddress());
		udto.setDateOfBirth(userEntity.getDateofbirth());
		udto.setEmail(userEntity.getEmail());
		udto.setGender(userEntity.getGender());
		udto.setPan(userEntity.getPan());
		udto.setPassword(userEntity.getPassword());

		return udto;
	}

}
