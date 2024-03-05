package com.infymeMobile.account.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "digital_bank_account")
public class DigitalBankingAccountEntity {

	@Id

	// @Generatedvalue(generator="system-uuid")
	// @GenericGenerator(name="system-uuid", strategy = "uuid")
	// @Generatedvalue(strategy =
	// GenerationType.SEQUENCE,generator="sequenceDigital")
	// @GenericGenerator(name = "sequenceDigital",
	// strategy
	// ="com.infymemobile.account.utility.StringprefixedSequenceIdGenerator",
	// parameters = {
	// @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value=
	// "1"),
	// @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
	// value = "w_"),
	// @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER,
	// value = "%d") })

	// w_1001
	@GeneratedValue(generator = "digital_bank_id")
	@GenericGenerator(name = "digital_bank_id", strategy = "com.infymeMobile.account.utility.DigitalBankIdGenerator")
	@Column(name = "digital_banking_id")
	private String digitalBankingId;

	@Column(name = "mobile_number")
	private long mobileNumber;

	@Column(name = "account number")
	private long accountNumber;

	@Column(name = "account type")
	private String accountType;

	public String getDigitalBankingId() {
		return digitalBankingId;
	}

	public void setDigitalBankingId(String digitalBankingId) {
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
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "DigitalBankingDTO [digitalBankingId=" + digitalBankingId + ",mobileNumber=" + mobileNumber
				+ ",accountNumber = " + accountNumber + ",accountType = " + accountType + "]";
	}

}
