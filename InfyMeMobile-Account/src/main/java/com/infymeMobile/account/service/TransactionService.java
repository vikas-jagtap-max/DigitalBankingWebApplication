package com.infymeMobile.account.service;

import java.util.List;

import com.infymeMobile.account.dto.TransactionDTO;
import com.infymeMobile.account.exception.InfyMeMobileGlobalHandlerException;

public interface TransactionService {
	
	public String fundTransfer (TransactionDTO transactionDTO) throws InfyMeMobileGlobalHandlerException;
	
	public List<TransactionDTO> accountStatement(Long mobileNo) throws InfyMeMobileGlobalHandlerException;

}
