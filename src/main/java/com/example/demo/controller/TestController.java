package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import commonConstants.CommonHtmlResponse;

@RestController
public class TestController {
	
	
	
	private CommonHtmlResponse COMMON_HTML_RESPONSE;

	@GetMapping("/")
	public String getData() {
		return COMMON_HTML_RESPONSE.ROOT;
	}
}
