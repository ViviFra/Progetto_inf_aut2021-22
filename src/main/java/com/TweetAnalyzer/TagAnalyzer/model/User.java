package com.TweetAnalyzer.TagAnalyzer.model;

import java.time.LocalDate;

public class User extends Super {
	
	private String username;

	

	public User(LocalDate date, long id, String name) {
		super(date, id);
		this.username = name;
	}



	public String getName() {
		return username;
	}

	
}
