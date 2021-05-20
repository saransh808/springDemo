package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MasterCountryStates;
import com.example.demo.response.ApiEntity;
import com.example.demo.response.ApiError;
import com.example.demo.response.ApiResponseObject;
import com.example.demo.serviceImpl.MasterCountryStatesImpl;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value="Master Country State Controller List")
@RestController
public class MasterCountryStatesController {

	@Autowired
	private MasterCountryStatesImpl masterCountryStatesImpl;
	
	@ApiOperation(value="Get All Country States")
	@GetMapping("/get-all-country-states")
	public ResponseEntity<ApiResponseObject> getAllCountryStates() {
		HttpStatus status = HttpStatus.OK;;
		HttpHeaders httpHeaders = new HttpHeaders();
		String message = "Success";
		try {
			List<MasterCountryStates> data =  masterCountryStatesImpl.findAll();
			if(data==null || data.isEmpty()) {
				status = HttpStatus.NO_CONTENT;
				message = "No data found";
				return new ResponseEntity<>(new ApiEntity(message, data), httpHeaders, status);
			}else {
				return new ResponseEntity<>(new ApiEntity(message, data), httpHeaders, status);
			}
		}catch(Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			message = e.getMessage();
			return new ResponseEntity<>(new ApiError(message), httpHeaders, status);

		}
	}
	
	@ApiOperation(value="Get All Country States Paged")
	@GetMapping("/get-all-country-states-paged")
	public ResponseEntity<ApiResponseObject> getAllCountryStatesPaged(@RequestParam Integer pageNumber) {
		HttpStatus status = HttpStatus.OK;;
		HttpHeaders httpHeaders = new HttpHeaders();
		String message = "Success";
		try {
			List<MasterCountryStates> data =  masterCountryStatesImpl.findAllPaged(pageNumber);
			if(data==null || data.isEmpty()) {
				status = HttpStatus.NO_CONTENT;
				message = "No data found";
				return new ResponseEntity<>(new ApiEntity(message, data), httpHeaders, status);
			}else {
				return new ResponseEntity<>(new ApiEntity(message, data), httpHeaders, status);
			}
		}catch(Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			message = e.getMessage();
			return new ResponseEntity<>(new ApiError(message), httpHeaders, status);

		}
	}
	
	@ApiOperation(value="Get All Country States Paged")
	@GetMapping("/find-country-states-by-id")
	public ResponseEntity<ApiResponseObject> findCountryStatesById(@RequestParam(name="stateId") Integer stateId) {
		HttpStatus status = HttpStatus.OK;;
		HttpHeaders httpHeaders = new HttpHeaders();
		String message = "Success";
		try {
			Optional<MasterCountryStates> data =  masterCountryStatesImpl.findById(stateId);
			if(data==null || data.isEmpty()) {
				status = HttpStatus.NO_CONTENT;
				message = "No data found";
				return new ResponseEntity<>(new ApiEntity(message, data), httpHeaders, status);
			}else {
				return new ResponseEntity<>(new ApiEntity(message, data), httpHeaders, status);
			}
		}catch(Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			message = e.getMessage();
			return new ResponseEntity<>(new ApiError(message), httpHeaders, status);

		}
	}
}
