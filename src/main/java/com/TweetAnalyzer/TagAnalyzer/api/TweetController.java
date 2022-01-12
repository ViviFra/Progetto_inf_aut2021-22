package com.TweetAnalyzer.TagAnalyzer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.TweetAnalyzer.TagAnalyzer.model.Tweet;
import com.TweetAnalyzer.TagAnalyzer.service.TweetService;

@RequestMapping("pippo")
@RestController
public class TweetController {
	
	private final TweetService tweetservice;

	@Autowired
	public TweetController(TweetService tweetservice) {
		this.tweetservice = tweetservice;
	}
	
	@PostMapping
	public void addTweet(@RequestBody Tweet tweet) {
		tweetservice.addTweet(tweet);
	}
	
	@GetMapping
	public List<Tweet> getallTweets() {
		 return tweetservice.getallTweets();
	}
}
