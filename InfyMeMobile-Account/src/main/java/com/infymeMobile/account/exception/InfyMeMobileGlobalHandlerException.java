package com.infymeMobile.account.exception;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class InfyMeMobileGlobalHandlerException extends Exception{
	
	@Enumerated(EnumType.STRING)
	private ExceptionConstants constant;
	//public class GlobalEducationException extends Exception{
		
		private static final long serialVersionUID = 1L;
		
		public InfyMeMobileGlobalHandlerException (String message) {
			super(message);
	}
	
	
	

}
