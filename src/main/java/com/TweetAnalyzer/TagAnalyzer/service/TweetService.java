package com.TweetAnalyzer.TagAnalyzer.service;

import com.TweetAnalyzer.TagAnalyzer.dao.TweetDao;
import com.TweetAnalyzer.TagAnalyzer.model.Tweet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TweetService {
	
	private final TweetDao tweetdao;

	@Autowired
	public TweetService(@Qualifier("Dao")TweetDao tweetdao) {

		this.tweetdao = tweetdao;
	}
	
	public int addTweet (Tweet tweet) {
		
		return tweetdao.insertTweet(tweet);
		
	}

	public List<Tweet> getallTweets () {
		
		return tweetdao.selectallTweets();
	}
}
