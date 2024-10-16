package com.infymeMobile.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infymeMobile.user.entity.UserEntity;

@Repository // defines a repository class
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	@Query("select u from UserEntity u where u.mobileNumber=?1") // Helps to write SQL Query in spring to retrieve data
																	// from

	// database
	Optional<UserEntity> findByMobileNumber(Long mobileNumber);

	@Query("select u from UserEntity u where u.mobileNumber=?1") // Helps to write SQL Query in spring to retrieve data
																	// from

	// database
	UserEntity findByMobileNumber1(Long mobileNumber);

	@Query("select u from UserEntity u where u.userId=?1") // Helps to write SQL Query in spring to retrieve data from
															// database
	UserEntity findById(String UserId);

	@Query("select u from UserEntity u") // Helps to write SQL Query in spring to retrieve data from database
	List<UserEntity> getAll();

	@Query("select u from UserEntity u where u.password=?1")
	UserEntity findByPassword(String loginpassword);

	// List<User> save()

}
