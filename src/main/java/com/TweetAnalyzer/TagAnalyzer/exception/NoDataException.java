package com.TweetAnalyzer.TagAnalyzer.exception;

//eccezione che interviene in caso di account senza contenuti propri

public class NoDataException extends Exception {

	private static final long serialVersionUID = 765691964415386681L;

	public NoDataException() {
		super();
	}

	public NoDataException(String message) {
		super(message);
	}
}
