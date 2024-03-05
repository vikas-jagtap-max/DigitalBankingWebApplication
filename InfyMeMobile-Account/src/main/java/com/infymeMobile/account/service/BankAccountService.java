package com.infymeMobile.account.service;

import java.util.List;

import com.infymeMobile.account.dto.BankAccountDTO;
import com.infymeMobile.account.exception.InfyMeMobileGlobalHandlerException;

public interface BankAccountService {

	public String createAccount(BankAccountDTO accountDTO) throws InfyMeMobileGlobalHandlerException;

	public List<BankAccountDTO> listAccounts(Long mobileNo) throws InfyMeMobileGlobalHandlerException;

	public double checkBalance(Long mobileNo, Long accountNo) throws InfyMeMobileGlobalHandlerException;

}
