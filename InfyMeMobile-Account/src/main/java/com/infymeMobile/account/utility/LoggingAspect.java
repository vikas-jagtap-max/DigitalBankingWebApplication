package com.infymeMobile.account.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;

public class LoggingAspect {

	public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	@AfterThrowing(pointcut = "execution(*com.infymemobile.account.service.*IMPL.*(..)", throwing = "exception")
	public void logServiceException(Exception exception) {
		LOGGER.error(exception);
	}

}
