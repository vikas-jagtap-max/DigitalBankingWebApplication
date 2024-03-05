package com.infymeMobile.account.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infymeMobile.account.entity.BankAccountEntity;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public class BankAccountDTO {
	@NotNull(message = "{bankaccount.accountnumber.notpresent}")
	// @min(value=7, message= "{bankaccount.accountnumber.invalid}")
	private long accountNumber;

	@NotNull(message = "{bankaccount.bankname.notpresent}")
	@Pattern(regexp = "[A-Za-z\\s]{5,15}", message = "{bankaccount.bankname.invalid}")
	private String bankName;

	@PositiveOrZero(message = "{bankaccount.balance.invalid}")
	private double balance;

	@NotNull(message = "{bankaccount.accounttype.notpresent}")
	@Pattern(regexp = "(Current|Saving|Salary)", message = "{bankaccount.accounttype.invalid}")
	private String accountType;

	@NotNull(message = "{bankaccount.ifsccode.notpresent}")
	@Pattern(regexp = "[A-Z]{4}[0-9]{7}", message = "{bankaccount.ifsccode.invalid}")
	private String ifscCode;

	@Past(message = "{bankaccount.openingdate.invalid}")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate openingDate;

	@NotNull(message = "{bankaccount.mobilenumber.notpresent}")
	@Digits(fraction = 0, integer = 10, message = "{bankaccount.mobilenumber.invalid}")
	// @Size(min=10, max=10, ,message="{bankaccount.mobilenumber.invalid}")
	private long mobileNumber;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String IfscCode) {
		this.ifscCode = ifscCode;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate OpeningDate) {
		this.openingDate = openingDate;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long MobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "BankAccountDTO [accountNumber=" + accountNumber + ", bankName= " + bankName + ", balance=" + balance
				+ ",accountType=" + accountType + ", ifscCode=" + ifscCode + ",openingDate= " + openingDate
				+ ",mobileNumber=" + mobileNumber + "]";
	}

	public static BankAccountEntity prepareBankAccountEntity(BankAccountDTO accountDTO) {
		BankAccountEntity bankAccountEntity = new BankAccountEntity();

		bankAccountEntity.setAccountNumber(accountDTO.getAccountNumber());
		bankAccountEntity.setBankName(accountDTO.getBankName());
		bankAccountEntity.setAccountType(accountDTO.getAccountType());
		bankAccountEntity.setBalance(accountDTO.getBalance());
		bankAccountEntity.setIfscCode(accountDTO.getIfscCode());
		bankAccountEntity.setOpeningDate(accountDTO.getOpeningDate());
		bankAccountEntity.setMobileNumber(accountDTO.getMobileNumber());

		return bankAccountEntity;
	}

	public static BankAccountDTO prepareBankAccountDTO(BankAccountEntity bankList) {
		BankAccountDTO bankAccountDTO = new BankAccountDTO();

		bankAccountDTO.setAccountNumber(bankList.getAccountNumber());
		bankAccountDTO.setBankName(bankList.getBankName());
		bankAccountDTO.setAccountType(bankList.getAccountType());
		bankAccountDTO.setBalance(bankList.getBalance());
		bankAccountDTO.setIfscCode(bankList.getIfscCode());
		bankAccountDTO.setOpeningDate(bankList.getOpeningDate());
		bankAccountDTO.setMobileNumber(bankList.getMobileNumber());

		return bankAccountDTO;
	}

}
