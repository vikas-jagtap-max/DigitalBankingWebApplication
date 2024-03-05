package com.infymeMobile.account.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infymeMobile.account.dto.TransactionDTO;
import com.infymeMobile.account.entity.BankAccountEntity;
import com.infymeMobile.account.entity.DigitalBankingAccountEntity;
import com.infymeMobile.account.entity.TransactionEntity;
import com.infymeMobile.account.exception.InfyMeMobileGlobalHandlerException;
import com.infymeMobile.account.repository.BankAccountRepository;
import com.infymeMobile.account.repository.DigitalBankAccountRepository;
import com.infymeMobile.account.repository.TransactionRepository;

@Service(value = "TransactionService")
@Transactional
public class TransactionServiceIMPL implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	BankAccountRepository bankAccountRepository;

	@Autowired
	DigitalBankAccountRepository digitalBankAccountRepository;

	@Override
	public String fundTransfer(TransactionDTO transactionDTO) throws InfyMeMobileGlobalHandlerException {

		DigitalBankingAccountEntity digitalBank = digitalBankAccountRepository.findByMobileNumberAndAccountNumber(
				transactionDTO.getPaidFrom(), transactionDTO.getSenderAccountNumber());
		if (digitalBank == null) {
			throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.ACCOUNT_NOT_LINKED");
		}
		DigitalBankingAccountEntity digitalBank1 = digitalBankAccountRepository.findByMobileNumberAndAccountNumber(
				transactionDTO.getPaidFrom(), transactionDTO.getSenderAccountNumber());
		if (digitalBank1 == null) {
			throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.ACCOUNT_NOT_LINKED");
		}
		BankAccountEntity bankSenderAccount = bankAccountRepository
				.findByAccountNumber1(transactionDTO.getSenderAccountNumber());
		if (transactionDTO.getAmount() > bankSenderAccount.getBalance()) {
			throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.INSUFFICIENT_FUNDS");
		}
		BankAccountEntity bankReceiverAccount = bankAccountRepository
				.findByAccountNumber1(transactionDTO.getSenderAccountNumber());
		TransactionEntity transactionEntity = TransactionDTO.prepareEntity(transactionDTO);
		transactionEntity = transactionRepository.save(transactionEntity);

		bankReceiverAccount.setBalance(bankReceiverAccount.getBalance() + transactionDTO.getAmount());
		bankReceiverAccount = bankAccountRepository.save(bankReceiverAccount);

		bankSenderAccount.setBalance(bankSenderAccount.getBalance() - transactionDTO.getAmount());
		bankSenderAccount = bankAccountRepository.save(bankSenderAccount);

		String fundTransfer = "The amount" + transactionDTO.getAmount() + " is transferred from "
				+ transactionDTO.getSenderAccountNumber() + " account to " + transactionDTO.getReceiverAccountNumber()
				+ "accont successfully";
		return fundTransfer;

	}

	@Override
	public List<TransactionDTO> accountStatement(Long mobileNo) throws InfyMeMobileGlobalHandlerException {

		// List<DigitalBankingAccountEntity> digitalBankingAccountEntity =
		// digitalBankAccountRepository.findByMobileNumber(mobileNo);
		// if(digitalBankingAccountEntity==null) {
		// throw new
		// InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.ACCOUNT_NOT_LINKED");
		// }

		// List<TransactionDTO> accountStatement=new ArrayList<>();

		// for(DigitalBankingAccountEntity x:digitalBankingAccountEntity) {
		List<TransactionEntity> transactionEntitY = transactionRepository.findByMobileNumber(mobileNo);
		if (transactionEntitY == null) {
			throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.NO_ACTIVE_TRANSACTION");
		}
		List<TransactionDTO> list1 = new ArrayList<>();
		for (TransactionEntity l1 : transactionEntitY) {
			TransactionDTO tDto = TransactionDTO.prepareTransactionDTO(l1);
			list1.add(tDto);
		}
//		    accountStatement.addAll(list1);
//		    }

		return list1;
	}

}
