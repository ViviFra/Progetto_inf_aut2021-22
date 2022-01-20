package com.TweetAnalyzer.TagAnalyzer.exception;

public class WrongNumOfPostException extends Exception {

	private static final long serialVersionUID = -2414066716861569654L;
	
	public WrongNumOfPostException() {
		super();
	}

	public WrongNumOfPostException(String message) {
		super(message);
	}
}