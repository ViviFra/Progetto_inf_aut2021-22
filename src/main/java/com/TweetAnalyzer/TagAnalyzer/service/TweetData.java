package com.TweetAnalyzer.TagAnalyzer.service;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

import com.TweetAnalyzer.TagAnalyzer.model.Tweet;

//classe che implementa TweetDataInterface

public class TweetData implements TweetDataInterface {

	private ArrayList<Tweet> tweets;

	public TweetData() {
	}

	public TweetData(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}

	//metodo che mostra i metadati con i quali andremo a lavorare
	
	@Override
	public JSONObject seeMetaData() {
		JSONObject meta = new JSONObject();
		JSONArray list = new JSONArray();
		JSONObject prop = new JSONObject();
		JSONObject tweet = new JSONObject();

		tweet.put("text", "String");
		tweet.put("id", "long");
		tweet.put("hashtags", "ArrayList<String>");
		prop.put("tweet", tweet);
		list.put(prop);
		meta.put("list", prop);

		return meta;
	}

	//metodo che mostra i dati precedentemente salvati ed eventualmente li filtra
	
	@Override
	public JSONObject seeData(String tag) {

		JSONObject data = new JSONObject();
		JSONArray list = new JSONArray();

		
		for (int k = 0; k < tweets.size(); k++) {

			JSONObject tweet = new JSONObject();
			JSONObject prop = new JSONObject();

			tweet.put("text", tweets.get(k).getText());
			tweet.put("id", tweets.get(k).getId());
			
			ArrayList<String> hashtags= tweets.get(k).getHashtags();
			if(tag != null && !hashtags.contains(tag))
				continue;
			tweet.put("hashtags", hashtags);
			prop.put("tweet", tweet);

			list.put(prop);
		}
		data.put("list", list);
		return data;
	}
}
