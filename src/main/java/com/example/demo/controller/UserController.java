package com.example.demo.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.userDTOs.UserDetailsDTO;
import com.example.demo.response.ApiEntity;
import com.example.demo.response.ApiError;
import com.example.demo.response.ApiResponseObject;
import com.example.demo.serviceImpl.user.UsersServiceImpl;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value="User Controller List")
@RestController
public class UserController {
	
	@Autowired
	private UsersServiceImpl usersServiceImpl;

	
	@ApiOperation(value="Get All Users")
	@PostMapping("/save-user")
	public ResponseEntity<ApiResponseObject> saveUserData(@RequestBody UserDetailsDTO dto) {
		HttpStatus status = HttpStatus.OK;
		HttpHeaders httpHeaders = new HttpHeaders();
		String message = "Success";
		
		try {
			usersServiceImpl.user(dto);
			return new ResponseEntity<>(new ApiEntity(message, dto.getUser().getUserFirstName()), httpHeaders, status);
		}catch(ConstraintViolationException e) {
			status = HttpStatus.CONFLICT;
			message = e.getMessage();
			return new ResponseEntity<>(new ApiError(message), httpHeaders, status);
		}catch(Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			message = e.getMessage();
			return new ResponseEntity<>(new ApiError(message), httpHeaders, status);
		}
		
		
		
		
		
		
	}
		
		
		
	
	@ApiOperation(value="Get All Users")
	@GetMapping("/get-all-users")
	public String getData() {
		
		return null;
		
		
		
	}
	
}
