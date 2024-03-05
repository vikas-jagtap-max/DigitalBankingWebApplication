package com.infymeMobile.account.exception;

public enum ExceptionConstants {
	SERVER_ERROR("server.error"),
	AUTHENTICATION_FAILED("authentication_failed"),
	USER_NOT_FOUND("user.not.found"),
	USERID_NOT_FOUND("userid.not.found"),
	NO_USERS_FOUND("no.users.found"),
	NO_ACCOUNTS_FOUND("no.accounts.found"),
	NO_ACCOUNT_IS_LINKED("no.account.is.linked"),
	INSUFFICIENT_FUNDS("insufficient.funds"),
	NO_ACTIVE_TRANSACTIONS("no.active.transactions");
	
	private final String type;
	private ExceptionConstants (String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return this.type;
	}
	
	

}
