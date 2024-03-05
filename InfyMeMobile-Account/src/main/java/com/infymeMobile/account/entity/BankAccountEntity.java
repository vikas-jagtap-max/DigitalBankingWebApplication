package com.infymeMobile.account.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank account")
@SequenceGenerator(name = "sequence", sequenceName = "sequence", initialValue = 100001, allocationSize = 1)
public class BankAccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	// @GeneratedValue(strategy= GenerationType.AUTO)
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account number")
	public long accountNumber;

	@Column(name = "bank name")
	public String bankName;

	@Column(name = "balance")
	public double balance;

	@Column(name = "account type")
	public String accountType;

	@Column(name = "ifsc code")
	public String ifscCode;

	@Column(name = "opening date")
	public LocalDate openingDate;

	public long mobileNumber;

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

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "BankAccountDTO [accountNumber=" + accountNumber + ",bankName=" + bankName + ",balance=" + balance
				+ ",accountType=" + accountType + ",ifscCode=" + ifscCode + ",openingDate=" + openingDate
				+ ",mobileNumber=" + mobileNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, accountType, balance, bankName, ifscCode, mobileNumber, openingDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccountEntity other = (BankAccountEntity) obj;
		return accountNumber == other.accountNumber && Objects.equals(accountType, other.accountType)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(bankName, other.bankName) && Objects.equals(ifscCode, other.ifscCode)
				&& mobileNumber == other.mobileNumber && Objects.equals(openingDate, other.openingDate);
	}

}
