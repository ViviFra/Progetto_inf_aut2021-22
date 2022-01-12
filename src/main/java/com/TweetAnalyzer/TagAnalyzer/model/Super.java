package com.TweetAnalyzer.TagAnalyzer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Super {
	
	private final String tag;

	public Super(@JsonProperty("tag")String tag) {
		this.tag = tag;
		JSONObject jo;
	}

	public String getTag() {
		return tag;
	}
	
	

}
