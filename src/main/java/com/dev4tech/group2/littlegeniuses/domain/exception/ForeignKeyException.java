package com.dev4tech.group2.littlegeniuses.domain.exception;

public class ForeignKeyException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ForeignKeyException(String message) {
		super(message);
	}
	
	public ForeignKeyException(Long id) {
		this(String.format("Entity with id %d is in use.", id));
	}
}
