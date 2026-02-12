package com.izamim.typeBot.services.exception;

public class NotFound extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public NotFound(Object id) {
		super("Resource Not Found. Id " + id);
	}

}
