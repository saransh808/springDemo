package com.example.demo.response;

public class ApiError extends ApiResponseObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String debugMessage;

	
	
	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	public ApiError() {
		super();
	}
	
	public ApiError(String message) {
		super();
		setMessage(message);
	}
	
	public ApiError(String message, String debugMessage) {
		super();
		setMessage(message);
		this.setDebugMessage(debugMessage);
	}

	public ApiError(Throwable ex) {
		super();
		setMessage("Error");
		this.debugMessage = "";
	}

	public ApiError(String message, Throwable ex) {
		super();
		setMessage(message);
		this.debugMessage = "";
	}
}
