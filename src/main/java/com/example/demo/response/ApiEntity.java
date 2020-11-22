package com.example.demo.response;

public class ApiEntity extends ApiResponseObject {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object data;
	private String message;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ApiEntity(String message, Object data) {
		super();
		setMessage(message);
		this.data = data;
	}
	
	public ApiEntity(String message) {
		setMessage(message);
	}

	public ApiEntity(Object data) {
		super();
		this.data = data;
	}
	
}
