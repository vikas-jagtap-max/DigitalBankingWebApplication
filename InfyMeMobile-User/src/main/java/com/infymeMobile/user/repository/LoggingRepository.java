package com.infymeMobile.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.infymeMobile.user.entity.LoggingEntity;

public interface LoggingRepository extends CrudRepository<LoggingEntity, Long> {
	@Query("select u from LoginEntity u where u.mobileNumber=?1")
	LoggingEntity findByMobileNumber1(Long mobileNumber);

}
