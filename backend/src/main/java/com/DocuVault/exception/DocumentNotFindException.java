package com.DocuVault.exception;

public class DocumentNotFindException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DocumentNotFindException(String msg) {
		super(msg);
	}
}
