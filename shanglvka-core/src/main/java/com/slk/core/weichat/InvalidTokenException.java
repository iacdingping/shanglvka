package com.slk.core.weichat;

public class InvalidTokenException extends Exception {

	private static final long serialVersionUID = -7359280918204545554L;

	public InvalidTokenException (String message) {
		super(message);
	}
	
	public InvalidTokenException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidTokenException (Throwable cause) {
		super(cause);
	}
}
