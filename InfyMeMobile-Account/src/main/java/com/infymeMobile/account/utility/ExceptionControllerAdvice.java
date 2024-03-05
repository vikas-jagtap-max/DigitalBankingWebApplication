package com.infymeMobile.account.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infymeMobile.account.exception.InfyMeMobileGlobalHandlerException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);

	@Autowired
	private Environment environment;

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalException(Exception exception) {
		LOGGER.error(exception.getMessage(), exception);
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
		errorInfo.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler({ MethodArgumentNotValidException.class, ConstraintViolationException.class })
	public ResponseEntity<ErrorInfo> validatorException(Exception exception) {
		LOGGER.error(exception.getMessage(), exception);
		String errormsg;
		if (exception instanceof MethodArgumentNotValidException) {
			MethodArgumentNotValidException methodArgException = (MethodArgumentNotValidException) exception;
			errormsg = methodArgException.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(" , "));

		} else {
			ConstraintViolationException constraintViolationException = (ConstraintViolationException) exception;
			errormsg = constraintViolationException.getConstraintViolations().stream()
					.map(ConstraintViolation::getMessage).collect(Collectors.joining(" , "));
		}
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMessage(errormsg);
		errorInfo.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);

	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<ErrorInfo> exceptionHandler(MethodArgumentNotValidException exception){
//		ErrorInfo errorInfo = new ErrorInfo();
//		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
//		errorInfo.setTimeStamp(LocalDateTime.now());
//		
//		String errorMsg = exception.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(" , "));
//		errorInfo.setErrorMessage(errorMsg);
//		return  new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
//	}
//	
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<ErrorInfo> pathExceptionHandler(ConstraintViolationException exception){
//		ErrorInfo errorInfo = new ErrorInfo();
//		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
//		errorInfo.setTimeStamp(LocalDateTime.now());
//		
//		String errorMsg = exception.getConstraintViolations().stream().map(x -> x.getMessage()).collect(Collectors.joining(" , "));
//		errorInfo.setErrorMessage(errorMsg);
//		return  new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
//	}
//	
	@ExceptionHandler(InfyMeMobileGlobalHandlerException.class)
	public ResponseEntity<ErrorInfo> CreateBankAccountException(InfyMeMobileGlobalHandlerException exception) {

		LOGGER.error(exception.getMessage(), exception);
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
		errorInfo.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);

	}

}
