package com.infymeMobile.account.dto;

import java.time.LocalDateTime;

import com.infymeMobile.account.entity.TransactionEntity;

import jakarta.validation.constraints.PastOrPresent;

public class TransactionDTO {

	public Integer transactionId;
	public static String modeOfTransaction;
	public Long paidTo;
	public Long receiverAccountNumber;
	public Double amount;
	@PastOrPresent(message = "transaction.transactiondatetime.invalid")
	public LocalDateTime transactionDateTime;
	public String remarks;
	public Long paidFrom;
	public Long senderAccountNumber;

	/**
	 * @return the transactionId
	 */
	public Integer getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the modeOfTransaction
	 */
	public static String getModeOfTransaction() {
		return modeOfTransaction;
	}

	/**
	 * @param modeOfTransaction the modeOfTransaction to set
	 */
	public static void setModeOfTransaction(String modeOfTransaction) {
		TransactionDTO.modeOfTransaction = modeOfTransaction;
	}

	/**
	 * @return the paidTo
	 */
	public Long getPaidTo() {
		return paidTo;
	}

	/**
	 * @param paidTo the paidTo to set
	 */
	public void setPaidTo(Long paidTo) {
		this.paidTo = paidTo;
	}

	/**
	 * @return the receiverAccountNumber
	 */
	public Long getReceiverAccountNumber() {
		return receiverAccountNumber;
	}

	/**
	 * @param receiverAccountNumber the receiverAccountNumber to set
	 */
	public void setReceiverAccountNumber(Long receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * @return the transactionDateTime
	 */
	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}

	/**
	 * @param transactionDateTime the transactionDateTime to set
	 */
	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the paidFrom
	 */
	public Long getPaidFrom() {
		return paidFrom;
	}

	/**
	 * @param paidFrom the paidFrom to set
	 */
	public void setPaidFrom(Long paidFrom) {
		this.paidFrom = paidFrom;
	}

	/**
	 * @return the senderAccountNumber
	 */
	public Long getSenderAccountNumber() {
		return senderAccountNumber;
	}

	/**
	 * @param senderAccountNumber the senderAccountNumber to set
	 */
	public void setSenderAccountNumber(Long senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}

	@Override
	public String toString() {
		return "TransactionDTO [transactionId=" + transactionId + ", paidTo=" + paidTo + ", receiverAccountNumber="
				+ receiverAccountNumber + ", amount=" + amount + ", transactionDateTime=" + transactionDateTime
				+ ", remarks=" + remarks + ", paidFrom=" + paidFrom + ", senderAccountNumber=" + senderAccountNumber
				+ "]";
	}

	public static TransactionEntity prepareEntity(TransactionDTO transactionDTO) {

		TransactionEntity transactionEntity = new TransactionEntity();

		transactionEntity.setModeOfTransaction(transactionDTO.getModeOfTransaction());
		transactionEntity.setPaidTo(transactionDTO.getPaidTo());
		transactionEntity.setReceiverAccountNumber(transactionDTO.getReceiverAccountNumber());
		transactionEntity.setAmount(transactionDTO.getAmount());
		transactionEntity.setTransactionDateTime(LocalDateTime.now());
		transactionEntity.setRemarks(transactionDTO.getRemarks());
		transactionEntity.setPaidFrom(transactionDTO.getPaidFrom());
		transactionEntity.setSenderAccountNumber(transactionDTO.getSenderAccountNumber());

		return transactionEntity;
	}

	public static TransactionDTO prepareTransactionDTO(TransactionEntity transactionEntity) {

		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setTransactionId(transactionEntity.getTransactionId());
		transactionDTO.setReceiverAccountNumber(transactionEntity.getReceiverAccountNumber());
		transactionDTO.setPaidTo(transactionEntity.getPaidTo());
		transactionDTO.setAmount(transactionEntity.getAmount());
		transactionDTO.setModeOfTransaction(transactionEntity.getModeOfTransaction());
		transactionDTO.setRemarks(transactionEntity.getRemarks());
		transactionDTO.setPaidFrom(transactionEntity.getPaidFrom());
		transactionDTO.setTransactionDateTime(transactionEntity.getTransactionDateTime());
		transactionDTO.setSenderAccountNumber(transactionEntity.getSenderAccountNumber());

		return transactionDTO;
	}

}
