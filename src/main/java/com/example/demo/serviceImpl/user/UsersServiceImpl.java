package com.example.demo.serviceImpl.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.userDTOs.UserDetailsDTO;

@Service
@Transactional
public class UsersServiceImpl {
	
	public String user(UserDetailsDTO userDetails) {
		if(userDetails.getUser().getUserIdPk()!=null) {
			
		}
		return null;
		
	}

}
