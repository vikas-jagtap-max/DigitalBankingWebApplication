package com.infymeMobile.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.infymeMobile.account.entity.DigitalBankingAccountEntity;

public interface DigitalBankAccountRepository extends CrudRepository<DigitalBankingAccountEntity, String> {

	@Query("Select d from DigitalBankingAccountEntity d where d.mobileNumber=?1 and d.accountNumber=?2")
	DigitalBankingAccountEntity findByMobileNumberAndBankAccountNumber(Long mobileNO, Long accountNo);

	@Query("Select a from DigitalBankingAccountEntity a where a.mobileNumber=?1")
	List<DigitalBankingAccountEntity> findByMobileNumber1(Long mobileNO);

	DigitalBankingAccountEntity findByMobileNumberAndAccountNumber(Long mobileNo, Long accountNo);

//	@Query("Select b from DigitalBankingAccountEntity b where b.mobileNumber=?1 and b.accountNumber=?2 OR b.mobileNumber=?3 and b.mobileNumber=?4")
//	DigitalBankingAccountEntity findByMobileNumberAndAccountNumber(Long paidFrom, Long senderAccountNumber, Long paidTo, Long receiverAccountNumber);
//	
//	@Query("Select e from DigitalBankingAccountEntity e where e.mobileNumber=?1 and b.accountNumber=?2 OR b.mobileNumber=?3 and b.accountNumber=?4")
//	DigitalBankingAccountEntity findByMobileNumberAndAccountNumber1(Long paidFrom, Long senderAccountNumber, Long paidTo, 
//			Long receiverAccountNumber);
//	

}
