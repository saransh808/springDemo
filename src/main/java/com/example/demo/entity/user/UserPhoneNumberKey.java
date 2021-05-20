package com.example.demo.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class UserPhoneNumberKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "I_USER_ID")
	private Integer userIdRef;

	@Column(name = "I_PHONE_NUMBER")
	private String phoneNumber;
}
