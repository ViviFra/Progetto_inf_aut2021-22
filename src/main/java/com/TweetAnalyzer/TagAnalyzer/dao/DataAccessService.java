package com.TweetAnalyzer.TagAnalyzer.dao;

import com.TweetAnalyzer.TagAnalyzer.model.Super;
import com.TweetAnalyzer.TagAnalyzer.model.Tweet;
import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("Dao")
public class DataAccessService implements TweetDao{
	
	private static List<Tweet> DB = new ArrayList<> ();

	@Override
	public int insertTweet(Tweet tweet) {
		DB.add(new Tweet(Tweet.getTag()));
		return 0;
	}

	@Override
	public List<Tweet> selectallTweets() {
		// TODO Auto-generated method stub
		return DB;
	}
	
	
	

}
