package com.infymeMobile.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class LoggingEntity {

	@Id
	@Column(name = "mobile_number")
	private Long mobileNumber;

	@Column(name = "password")
	private String password;

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [mobileNumber=" + mobileNumber + ",password=" + password + "]";
	}

}
