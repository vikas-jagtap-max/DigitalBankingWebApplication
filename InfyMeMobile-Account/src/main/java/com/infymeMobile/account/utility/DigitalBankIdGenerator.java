package com.infymeMobile.account.utility;

import java.time.LocalDateTime;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.EventType;
import org.hibernate.id.IdentifierGenerator;

public class DigitalBankIdGenerator implements  IdentifierGenerator {
	private static int counter = 1001;
	
	@Override
	public Object generate(SharedSessionContractImplementor session, Object  Object ) {
		int id = counter++;
		//LocalDateTime now = LocalDateTime.now();
		String value = "W_";
		return value + id;
	}

}
