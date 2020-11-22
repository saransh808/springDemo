package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.commonConstants.CommonHtmlResponse;
import com.example.demo.repository.MasterFlagsRepository;

@RestController
public class TestController {
	
	@Autowired
	private MasterFlagsRepository masterFlagsRepository;
	
	private CommonHtmlResponse COMMON_HTML_RESPONSE;

	@GetMapping("/")
	public String getData() {
		
		System.out.println(masterFlagsRepository.findAll());
		return COMMON_HTML_RESPONSE.ROOT;
	}
}
