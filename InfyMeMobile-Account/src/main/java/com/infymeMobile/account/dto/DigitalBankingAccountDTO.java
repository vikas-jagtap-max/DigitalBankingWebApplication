package com.infymeMobile.account.dto;

import com.infymeMobile.account.entity.BankAccountEntity;
import com.infymeMobile.account.entity.DigitalBankingAccountEntity;

public class DigitalBankingAccountDTO {
	public String digitalBankingId;
	public long mobileNumber;
	public long accountNumber;
	public String accontType;

	public String getDigitalBankingId() {
		return digitalBankingId;
	}

	public void setDigitalbankingId(String digitalBankingId) {
		this.digitalBankingId = digitalBankingId;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accontType;
	}

	public void setAccountType(String accontType) {
		this.accontType = accontType;
	}

	@Override
	public String toString() {
		return "DigitalBankingAccountDTO [digitalBankingID=" + digitalBankingId + ", mobileNumber=" + mobileNumber
				+ ", accountNumber=" + accountNumber + ", accontType=" + accontType + "]";
	}

	public static DigitalBankingAccountEntity prepareDigitalBankAccountEntity(BankAccountEntity bankDetails) {
		
		DigitalBankingAccountEntity dbaDTO = new DigitalBankingAccountEntity();

		dbaDTO.setAccountNumber(bankDetails.getAccountNumber());
		dbaDTO.setMobileNumber(bankDetails.getMobileNumber());
		dbaDTO.setAccountType(bankDetails.getAccountType());

		return dbaDTO;
	}

}
