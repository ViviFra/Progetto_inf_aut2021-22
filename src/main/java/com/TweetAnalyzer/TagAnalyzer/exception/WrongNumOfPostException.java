package com.TweetAnalyzer.TagAnalyzer.exception;

//eccezione che interviene in caso "max_results" fuori dai paramenti imposti dall'API 

public class WrongNumOfPostException extends Exception {

	private static final long serialVersionUID = -2414066716861569654L;
	
	public WrongNumOfPostException() {
		super();
	}

	public WrongNumOfPostException(String message) {
		super(message);
	}
}