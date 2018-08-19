package com.ps.demo.exception;

public class UserInvalidException extends RuntimeException {
	private static final long serialVersionUID = -2588044961586716655L;
	
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserInvalidException(String userId) {
		super("User is invalid.");
		this.userId = userId;
	}
}
