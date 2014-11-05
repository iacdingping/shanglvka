package com.slk.core.weichat;

public class ResponseError extends Exception {

	private static final long serialVersionUID = 3724099503404613313L;

	public ResponseError (String message) {
		super(message);
	}
	
	public ResponseError (String message, Throwable cause) {
		super(message, cause);
	}
	
	public ResponseError (Throwable cause) {
		super(cause);
	}
}
