package com.TweetAnalyzer.TagAnalyzer.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tweet extends Super {

	private ArrayList<String> hashtags;

	public Tweet(LocalDate date, long id, ArrayList<String> hashtags) {
		super(date, id);
		this.hashtags = hashtags;
	}

	public ArrayList<String> getHashtags() {
		return hashtags;
	}

}
