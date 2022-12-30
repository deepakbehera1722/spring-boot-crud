package com.crud.dto;

public class ErrorDto {
	private String message;

	private String msgKey;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}

	public ErrorDto(String message, String msgKey ) {
		super();
		this.message = message;
		this.msgKey = msgKey;
		
	}

	public ErrorDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
