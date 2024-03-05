package com.infymeMobile.user.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // to define that a class can be mapped to a table
@Table(name = "user") // it specifies which table should be mapped with database
public class UserEntity {

	@Id // defines which is the primary key
	// @GeneratedValue(strategy = GenerationType.IDENTITY) //Defines that the data
	// auto-generated is IDENTITY type
	@Column(name = "mobile_number") // it specifies which column should be mapped with database
	private Long mobileNumber;

	@Column(name = "user_id") // it specifies which column should be mapped with database
	private String userId;

	@Column(name = "account_holder_name") // it specifies which column should be mapped with database
	private String accountHolderName;

	private String gender;

	@Column(name = "date_of_birth") // it specifies which column should be mapped with database
	private LocalDate dateofbirth;

	private String password;

	private String email;

	@Column(name = "communication_address") // it specifies which column should be mapped with database
	private String communicationAddress;

	@Column(name = "pan") // it specifies which column should be mapped with database
	private String pan;

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCommunicationAddress() {
		return communicationAddress;
	}

	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

}
