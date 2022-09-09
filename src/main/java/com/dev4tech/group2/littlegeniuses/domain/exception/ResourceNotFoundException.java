package com.dev4tech.group2.littlegeniuses.domain.exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(Long id) {
		this(String.format("There is no registration with the code %d", id));
	}
}
