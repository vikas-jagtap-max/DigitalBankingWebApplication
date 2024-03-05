package com.infymeMobile.user.utility;

import java.time.LocalDateTime;

public class ErrorInfo {
	private String errorMessage;
	private int errorCode;
	private LocalDateTime timeStamp;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ErrorInfo [errorMessage=" + errorMessage + ", errorCode=" + errorCode + ", timeStamp=" + timeStamp
				+ "]";
	}
	
	

}
