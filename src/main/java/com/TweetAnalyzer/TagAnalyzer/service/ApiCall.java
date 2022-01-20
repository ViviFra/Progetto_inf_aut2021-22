package com.TweetAnalyzer.TagAnalyzer.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.TweetAnalyzer.TagAnalyzer.exception.NoDataException;
import com.TweetAnalyzer.TagAnalyzer.exception.WrongNumOfPostException;
import com.TweetAnalyzer.TagAnalyzer.model.Tweet;

public class ApiCall implements ApiCallInterface {

	private static final String Bearer = "AAAAAAAAAAAAAAAAAAAAAPtpWgEAAAAAB7CslNs4ZH8ZF0kN77z3hGxTQ5Q%3DFf82bnl3H4Ub5G6r0jOseCzochHkCio17X8qUGvw0iqqO1qYMq";
	private static final String apidefbase = "https://api.twitter.com/2/users/";
	private String apifinal;
	private String idtopass;
	private int num;

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

	public ApiCall(String idtopass, int num) {
		super();
		this.idtopass = idtopass;
		this.num = num;
	}

	@Override
	public String buildApiurl() throws WrongNumOfPostException {
		if (num > 4 && num < 101) {
			apifinal = apidefbase + idtopass + "/tweets?tweet.fields=entities&exclude=retweets,replies&max_results="
					+ num;
		} else {
			throw new WrongNumOfPostException("ERROR: post number must be between 5 and 100");
		}
		return apifinal;
	}

	@Override
	public String saveTweets() throws NoDataException, WrongNumOfPostException {
		String body = "";
		String line = "";
		JSONObject obj = new JSONObject();

		try {
			String url = this.buildApiurl();
			HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();

			httpConnection.setRequestProperty("Authorization", "Bearer " + Bearer);
			httpConnection.setRequestProperty("Content-Type", "application/json");

			InputStream in = httpConnection.getInputStream();
			BufferedReader buf = new BufferedReader(new InputStreamReader(in));
			while ((line = buf.readLine()) != null) {
				body += line;
			}
			in.close();
			obj = new JSONObject(body);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!obj.has("data")) {
			throw new NoDataException("ERROR: no data found!");
		}
		JSONArray data = (JSONArray) obj.get("data");
		for (int i = 0; i < data.length(); i++) {
			JSONObject tweet = (JSONObject) data.get(i);

			String tweetText = (String) tweet.get("text");
			String tweetId = (String) tweet.get("id");
			ArrayList<String> hashtags = new ArrayList<String>();
			if (tweet.has("entities")) {
				JSONObject entities = (JSONObject) tweet.get("entities");
				if (entities.has("hashtags")) {
					JSONArray ht = (JSONArray) entities.get("hashtags");
					for (int j = 0; j < ht.length(); j++) {
						JSONObject hashtag = (JSONObject) ht.get(j);
						String tag = (String) hashtag.get("tag");
						hashtags.add(tag);
					}
				}
			}
			Tweet tw = new Tweet(tweetId, tweetText, hashtags);
			tweets.add(tw);

		}
		return "See  DATA at http://localhost:8080/tweet/data";
	}

	@Override
	public ArrayList<Tweet> getTweets() {
		return tweets;
	}

}
