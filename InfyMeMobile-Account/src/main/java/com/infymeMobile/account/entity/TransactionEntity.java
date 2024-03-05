package com.infymeMobile.account.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
@SequenceGenerator(name = "sequenceTransaction", sequenceName = "sequenceTransaction", initialValue = 100001, allocationSize = 1)
public class TransactionEntity {
	public static TransactionEntity transactionEntity;

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceTransaction")
	@Column(name = "transaction_id")
	private Integer transactionId;

	@Column(name = "mode_of_transaction")
	private String modeOfTransaction;

	@Column(name = "paid_to")
	private Long paidTo;

	@Column(name = "receiver_account_number")
	private Long receiverAccountNumber;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "transaction_date_time")
	private LocalDateTime transactionDateTime;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "paid_from")
	private Long paidFrom;

	@Column(name = "sender_account_number")
	private Long senderAccountNumber;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getModeOfTransaction() {
		return modeOfTransaction;
	}

	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}

	public Long getPaidTo() {
		return paidTo;
	}

	public void setPaidTo(Long paidTo) {
		this.paidTo = paidTo;
	}

	public Long getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	public void setReceiverAccountNumber(Long receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getPaidFrom() {
		return paidFrom;
	}

	public void setPaidFrom(Long paidFrom) {
		this.paidFrom = paidFrom;
	}

	public Long getSenderAccountNumber() {
		return senderAccountNumber;
	}

	public void setSenderAccountNumber(Long senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}

	@Override
	public String toString() {
		return "TransactionalDTO [transactionId=" + transactionId + ",modeoftransaction=" + modeOfTransaction
				+ ",paidTo=" + paidTo + ",receiveraccountnumber=" + receiverAccountNumber + ",amount=" + amount
				+ ",transactionDateTime=" + transactionDateTime + ",remarks=" + remarks + ",paidFrom=" + paidFrom
				+ ",senderAccountNumber=" + senderAccountNumber + "]";
	}

}
