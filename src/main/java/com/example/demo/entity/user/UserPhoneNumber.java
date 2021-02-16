package com.example.demo.entity.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER_PHONE_NUMBER", schema="sorion")
public class UserPhoneNumber{

	@EmbeddedId
	private UserPhoneNumberKey phoneKey;
	
	@Column(name="I_FLAG_ID")
	private Integer flagIdRef;
	
	@Column(name="T_TIMESTAMP_ADD")
	private LocalDateTime timeStmpAdd;
	
	@Column(name="T_TIMESTAMP_UPD")
	private LocalDateTime timeStmpUpd;
}
