package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.user.UserPhoneNumber;
import com.example.demo.entity.user.UserPhoneNumberKey;

@Repository
public interface PhoneNumbersRepository extends JpaRepository<UserPhoneNumber, UserPhoneNumberKey>{
	
	@Modifying
	@Query(value="DELETE from sorion.USER_PHONE_NUMBER where I_USER_ID = ?1", nativeQuery=true)
	public Integer deletePhoneNumbersByUserId(Integer userIdRef);

}
