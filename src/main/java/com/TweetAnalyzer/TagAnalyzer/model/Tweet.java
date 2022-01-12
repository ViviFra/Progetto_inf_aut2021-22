package com.TweetAnalyzer.TagAnalyzer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tweet extends Super {

	private final String id;
	private final String user;
	
	

	public Tweet(@JsonProperty("tag")String tag, 
			     @JsonProperty("id")String id, 
			     @JsonProperty("username")String user) {
		super(tag);
		this.id = id;
		this.user = user;
	}



	public String getId() {
		return id;
	}

	public String getUser() {
		return user;
	}


	
}
