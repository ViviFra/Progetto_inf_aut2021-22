package com.TweetAnalyzer.TagAnalyzer.model;

import java.util.ArrayList;

public class Tweet extends Super {

	private String text;
	private ArrayList<String> hashtags;

	public Tweet(String id, String text, ArrayList<String> hashtags) {
		super(id);
		this.text = text;
		this.hashtags = hashtags;
	}

	public String getText() {
		return text;
	}

	public ArrayList<String> getHashtags() {
		return hashtags;
	}

}
