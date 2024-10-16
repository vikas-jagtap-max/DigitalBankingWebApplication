package com.infymeMobile.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infymeMobile.user.entity.LoggingEntity;

@Repository
public interface LoggingRepository extends CrudRepository<LoggingEntity, Long> {
	@Query("select u from LoggingEntity u where u.mobileNumber=?1")
	LoggingEntity findByMobileNumber1(Long mobileNumber);

}
