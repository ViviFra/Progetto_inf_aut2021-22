package com.TweetAnalyzer.TagAnalyzer.dao;

import java.util.List;

import com.TweetAnalyzer.TagAnalyzer.model.Tweet;

public interface TweetDao {
	
	int insertTweet(Tweet tweet);
	
	List<Tweet> selectallTweets();

}
