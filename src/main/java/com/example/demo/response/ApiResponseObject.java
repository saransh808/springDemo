package com.example.demo.response;


import java.time.LocalDateTime;
import java.io.*;

public class ApiResponseObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDateTime timestamp;
	private String message;

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ApiResponseObject() {
		this.timestamp = LocalDateTime.now();
	}
	
	
}
