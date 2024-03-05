package com.infymeMobile.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infymeMobile.account.dto.BankAccountDTO;
import com.infymeMobile.account.entity.BankAccountEntity;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccountEntity, Long> {
	@Query("Select b from BankAccountEntity b")
	List<BankAccountEntity> getAll();

	@Query("Select c from BankAccountEntity c where c.mobileNumber=?1")
	List<BankAccountEntity> findByMobileNumber1(Long mobileNO);

	// @Query("Select c from BankAccountEntity c where c.mobileNumber=?1")
	BankAccountEntity findByMobileNumber(Long mobileNO);

	// @Query("Select d from BankAccountEntity d where d.accountNumber=?1")
	// BankAccountEntity findByMobileNumber (Long senderAccountNumber);

	@Query("Select e from BankAccountEntity e where e.mobileNumber=?1 AND e.accountNumber=?2")
	BankAccountEntity findByMobileNumberAndBankAccountNumber(Long mobileNO, Long AccountNumber);

	@Query("Select f from BankAccountEntity f where f.accountNumber=?1")
	BankAccountEntity findByAccountNumber1(Long accountNO);

	// BankAccountEntity save(BankAccountEntity newBankAccount);

}
