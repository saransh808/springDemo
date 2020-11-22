package com.example.demo.controller;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MasterFlags;
import com.example.demo.response.ApiEntity;
import com.example.demo.response.ApiError;
import com.example.demo.response.ApiResponseObject;
import com.example.demo.serviceImpl.MasterFlagServiceImpl;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value="Master Flag Controller List")
@RestController
public class MasterFlagsController {

	@Autowired
	private MasterFlagServiceImpl masterFlagServiceImpl;
	
	@ApiOperation(value="Get All Flags")
	@GetMapping("/get-all-flags")
	public ResponseEntity<ApiResponseObject> getAllFlags() {
		HttpStatus status = HttpStatus.OK;;
		HttpHeaders httpHeaders = new HttpHeaders();
		String message = "Success";
		try {
			List<MasterFlags> data =  masterFlagServiceImpl.findAll();
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
	
	
	@ApiOperation(value="Create Flag")
	@PostMapping("/save-flag")
	public ResponseEntity<ApiResponseObject> saveFlag(@RequestBody MasterFlags masterFlag) throws Exception {
		HttpStatus status = HttpStatus.OK;
		HttpHeaders httpHeaders = new HttpHeaders();
		String message = "Success";
		
		try {
			MasterFlags data = masterFlagServiceImpl.create(masterFlag);
			return new ResponseEntity<>(new ApiEntity(message, data), httpHeaders, status);
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
	
	
	
	
//	@ApiOperation("Save Update Offer")
//	@PostMapping("/offer") //new annotation since 4.3
//	public ResponseEntity<ApiResponseObject> saveOfferNew(@RequestBody MasterFlags DraftOfferDto) {
//		
//		
//		HttpStatus status = HttpStatus.OK;
//		HttpHeaders httpHeaders = new HttpHeaders();
//		String message = "Error Occured";
//		try {
//			
//			message = "Offer is successfully "+op+" with ID: " + dto.getOffer().getOfrId();
//			System.out.println(dto.getOffer());
//			if(dto.getOffer().getVersion()==null || dto.getOffer().getVersion()==0) {
//				
//			}else message+="-v"+dto.getOffer().getVersion().toString();
//			return new ResponseEntity<>(new ApiEntity(message, dto.getOffer().getOfrId()), httpHeaders, status);
//		} catch (Exception e) {
//			String op = "";
//			op = isUpdated==null?"create":"update";
//			message = "Cannot "+op+" Offer";
//			logger.error(message);
//			status = HttpStatus.INTERNAL_SERVER_ERROR;
//			return new ResponseEntity<>(new ApiError(message), httpHeaders, status);
//		}
//	}
	
	
	
}
