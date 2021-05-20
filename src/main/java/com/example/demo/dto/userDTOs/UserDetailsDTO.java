package com.example.demo.dto.userDTOs;

import java.util.List;

import com.example.demo.entity.user.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDTO {
	private Users user;
	private List<UserPhoneNumberDTO> phoneNumbers;

}
