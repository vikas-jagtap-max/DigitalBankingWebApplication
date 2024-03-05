package com.infymeMobile.account.service;

import com.infymeMobile.account.entity.DigitalBankingAccountEntity;
import com.infymeMobile.account.exception.InfyMeMobileGlobalHandlerException;

public interface DigitalBankAccountService {
	
	String linkAccount(Long mobileNo, Long accountNo) throws InfyMeMobileGlobalHandlerException;
	
	String linkAccount(Long mobileNo, Long accountNo, Integer OTP) throws InfyMeMobileGlobalHandlerException;

	static DigitalBankingAccountEntity findByMobileNumberAndAccountNumber(Long mobileNo, Long accountNo) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
