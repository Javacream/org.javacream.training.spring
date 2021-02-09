package org.javacream.books.warehouse.api;

import java.io.Serializable;

public class BookException extends Exception {

	private static final long serialVersionUID = 3617860789252142136L;
	public BookExceptionType type; 
	public BookException(BookExceptionType type, String message){
		super(message);
		this.type = type;
		
	}
	
	public String getMessage(){
		return type.messageType + ":" + super.getMessage();
	}
	public static enum BookExceptionType implements Serializable{
		NOT_FOUND ("Book not found"),
		NOT_CREATED ("Book not created"),
		NOT_DELETED ("Book not deleted"),
		TECHNICAL("Runtime Failed"),
		CONSTRAINT("Constraint violation");
        private static final long serialVersionUID = 1L;
        private String messageType; 
		private BookExceptionType(String messageType){
			this.messageType = messageType;
		}
	}
}
