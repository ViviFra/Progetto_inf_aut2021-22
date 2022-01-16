package com.TweetAnalyzer.TagAnalyzer.model;

import java.time.LocalDate;

public class User extends Super {
	private String name;

	

	public User(LocalDate date, long id, String name) {
		super(date, id);
		this.name = name;
	}



	public String getName() {
		return name;
	}

	
}
