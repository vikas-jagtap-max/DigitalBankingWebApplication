package com.infymeMobile.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.infymeMobile.account.entity.TransactionEntity;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
	
	@Query("Select a from TransactionEntity a where a.paidTo=?1 OR a.paidFrom=?1")
	List<TransactionEntity> findByMobileNumber(Long mobileNO);
	
//	@Query("Select b from TransactionEntity b where b.senderAccountNumber=?1")
//	List<TransactionEntity> findByAccountNumber(Long accountNumber);
//
//	
//	@Query("Select b from TransactionEntity b where b.mobileNumber=?1")
//	List<TransactionEntity> findByMobileNumber1(Long mobileNO);



}
