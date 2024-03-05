package com.infymeMobile.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infymeMobile.account.dto.DigitalBankingAccountDTO;
import com.infymeMobile.account.entity.BankAccountEntity;
import com.infymeMobile.account.entity.DigitalBankingAccountEntity;
import com.infymeMobile.account.exception.InfyMeMobileGlobalHandlerException;
import com.infymeMobile.account.repository.BankAccountRepository;
import com.infymeMobile.account.repository.DigitalBankAccountRepository;
import com.infymeMobile.account.utility.OTPUtility;

@Service(value = "DigitalBankAccountService")
@Transactional
public class DigitalBankAccountServiceIMPL implements DigitalBankAccountService {

	@Autowired
	BankAccountRepository bankAccountRepository;

	@Autowired
	DigitalBankAccountRepository digitalBankAccountRepository;

	@Override
	public String linkAccount(Long mobileNo, Long accountNo) throws InfyMeMobileGlobalHandlerException {
		BankAccountEntity bankDetails = bankAccountRepository.findByMobileNumberAndBankAccountNumber(mobileNo,
				accountNo);
		if (bankDetails == null) {
			throw new InfyMeMobileGlobalHandlerException(
					"InfyMeMobileGlobalHandlerException.N0_ACCOUNTS_FOUND_FOR_MOBILE_NUMBER_AND_ACCOUNT_NUMBER");
		}

		DigitalBankingAccountEntity dbaentity = DigitalBankAccountService.findByMobileNumberAndAccountNumber(mobileNo,
				accountNo);
		if (dbaentity != null) {
			throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.USER_ALREADY_LINKED");
		}

		DigitalBankingAccountEntity dbae = DigitalBankingAccountDTO.prepareDigitalBankAccountEntity(bankDetails);
		dbae = digitalBankAccountRepository.save(dbae);

		String linkaccountValid = "The Mobile Number " + dbae.getMobileNumber() + " is linked to Account Number "
				+ dbae.getAccountNumber();
		return linkaccountValid;

	}

	@Override
	public String linkAccount(Long mobileNo, Long accountNo, Integer OTP) throws InfyMeMobileGlobalHandlerException {
		BankAccountEntity bankDetails = bankAccountRepository.findByMobileNumberAndBankAccountNumber(mobileNo,
				accountNo);
		if (bankDetails == null) {
			throw new InfyMeMobileGlobalHandlerException(
					"InfyMeMobileGlobalHandlerException.N0_ACCOUNTS_FOUND_FOR_MOBILE_NUMBER_AND_ACCOUNT_NUMBER");
		}

		DigitalBankingAccountEntity dbaentity = digitalBankAccountRepository
				.findByMobileNumberAndBankAccountNumber(mobileNo, accountNo);
		if (dbaentity != null) {
			throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.USER_ALREADY_LINKED");
		}

		else {
			OTPUtility otp1 = new OTPUtility();
			Integer otpdata = otp1.sendOTP();
			if (OTP.equals(otpdata) == Boolean.FALSE) {
				throw new InfyMeMobileGlobalHandlerException("InfyMeMobileGlobalHandlerException.OTP_DOES_NOT_MATCH");
			}

			else {
				DigitalBankingAccountEntity dbae = DigitalBankingAccountDTO
						.prepareDigitalBankAccountEntity(bankDetails);
				dbae = digitalBankAccountRepository.save(dbae);

				String linkaccountValid = "The Mobile Number " + dbae.getMobileNumber()
						+ " is linked to Account Number " + dbae.getAccountNumber();
				return linkaccountValid;

			}
		}

	}

}
