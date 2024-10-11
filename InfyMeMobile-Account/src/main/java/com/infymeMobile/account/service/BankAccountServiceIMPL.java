package com.infymeMobile.account.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infymeMobile.account.dto.BankAccountDTO;
import com.infymeMobile.account.entity.BankAccountEntity;
import com.infymeMobile.account.entity.DigitalBankingAccountEntity;
import com.infymeMobile.account.exception.InfyMeMobileGlobalHandlerException;
import com.infymeMobile.account.repository.BankAccountRepository;
import com.infymeMobile.account.repository.DigitalBankAccountRepository;

@Service(value = "BankAccountService")
@Transactional
public class BankAccountServiceIMPL implements BankAccountService {

	@Autowired
	BankAccountRepository bankAccountRepository;

	@Autowired
	DigitalBankAccountRepository digitalBankAccountRepository;

	// @CachePut(key = "#accountNo", value = "accounts")
	@Override
	public String createAccount(BankAccountDTO accountDTO) throws InfyMeMobileGlobalHandlerException {
//		BankAccountEntity bank1 = bankAccountRepository.findByMobileNumberAndBankAccountNumber(accountDTO.getAccountNumber(), accountDTO.getMobileNumber());
//		
//		if(bank1! =null) {
//			throw new InfyMeMobileGlobalHandlerException ("InfyMeMobileGlobalHandlerException.ACCOUNT_ALREADY_EXIST");
//		}

		BankAccountEntity newBankAccount = BankAccountDTO.prepareBankAccountEntity(accountDTO);
		newBankAccount = bankAccountRepository.save(newBankAccount);
		String output = "The details for " + newBankAccount.getMobileNumber()
				+ " has been saved. The Account Number is " + newBankAccount.getAccountNumber();
		return output;
	}

	// @Cacheable(key = "#mobileNo", value = "accounts")
	@Override
	public List<BankAccountDTO> listAccounts(Long mobileNo) throws InfyMeMobileGlobalHandlerException {
		List<BankAccountEntity> list1 = bankAccountRepository.findByMobileNumber1(mobileNo);

		if (list1.isEmpty()) {
			throw new InfyMeMobileGlobalHandlerException(
					"InfyMeMobileGlobalHandlerException.N0_ACCOUNTS_FOUND_FOR_MOBILE_NUMBER");

		}

		// BankAccountEntity bankAccount = BankAccountDTO.prepareBankAccountDTO(list1);
		List<BankAccountDTO> list2 = new ArrayList<>();
		for (BankAccountEntity b1 : list1) {
			BankAccountDTO bankdetails = BankAccountDTO.prepareBankAccountDTO(b1);
			list2.add(bankdetails);
		}
		return list2;
	}

	// @Cacheable(key = "#mobileNo", value = "accounts")
	@Override
	public double checkBalance(Long mobileNo, Long accountNo) throws InfyMeMobileGlobalHandlerException {
		BankAccountEntity bankDetail = bankAccountRepository.findByMobileNumberAndBankAccountNumber(mobileNo,
				accountNo);
		if (bankDetail == null) {
			throw new InfyMeMobileGlobalHandlerException(
					"InfyMeMobileGlobalHandlerException.N0_ACCOUNTS_FOUND_FOR_MOBILE_NUMBER_AND_ACCOUNT_NUMBER");
		}

		DigitalBankingAccountEntity user1 = digitalBankAccountRepository
				.findByMobileNumberAndBankAccountNumber(mobileNo, accountNo);
		if (user1 == null) {
			throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.N0_ACCOUNT_IS_LINKED");
		} else {
			BankAccountEntity bankEntity = bankAccountRepository.findByAccountNumber1(accountNo);
//			BankAccountDTO bankAccountDTO = new BankAccountDTO();
//			BankAccountEntity bankAccountEntity = new BankAccountEntity();

			BankAccountDTO bankDeatils = BankAccountDTO.prepareBankAccountDTO(bankEntity);
			// bankAccountDTO.setBalance(bankAccountEntity.getBalance());
			Double bankBalance = bankDetail.getBalance();
			// Double bankBalance = bankEntity.getBalance();

			return bankBalance;
		}

	}

	private void findByMobileNumberAndBankAccountNumber(Long mobileNo, Long accountNo) {

	}

}
