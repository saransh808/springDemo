package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.commonConstants.CommonHtmlResponse;
import com.example.demo.repository.MasterFlagsRepository;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value="TEST CONTROLLER")
@RestController
public class TestController {
	
	@Autowired
	private MasterFlagsRepository masterFlagsRepository;
	
	private CommonHtmlResponse COMMON_HTML_RESPONSE;

	@ApiOperation(value="TEST API")
	@GetMapping("/test")
	public String getData() {
		
		System.out.println(masterFlagsRepository.findAll());
		return COMMON_HTML_RESPONSE.ROOT;
	}
}
