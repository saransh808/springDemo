package com.example.demo.dto.userDTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPhoneNumberDTO {
	private boolean isPrimary;
	private String phoneNumber;
}
