package com.TweetAnalyzer.TagAnalyzer.stats;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Stats{
	
	JSONObject data;
	
	public Stats(JSONObject data) {
		this.data = data;
	}

	public JSONObject seeStats() {
		
		int numHashtags = 0;
        Map<String, Integer> hashMap = new HashMap<String, Integer>();		
		JSONArray tweetList = (JSONArray) data.get("list");
		for(int i=0;i<tweetList.length();i++) {
			JSONObject prop = (JSONObject) tweetList.get(i);
			JSONObject tweet = (JSONObject) prop.get("tweet");
			JSONArray hashtags = (JSONArray) tweet.get("hashtags");
			numHashtags += hashtags.length();
			for (int j=0; j<hashtags.length(); j++) {
				String hashtag = (String) hashtags.get(j);
				if (hashMap.containsKey(hashtag)) {
					Integer numtag = hashMap.get(hashtag);
					hashMap.put(hashtag, numtag + 1);
				} else {
					hashMap.put(hashtag, 1);
				}
			}
		}
		JSONObject response = new JSONObject();
		response.put("hashnum",numHashtags);
		response.put("hashaverage",(float)numHashtags/tweetList.length());		
		response.put("hashtags", new JSONObject(hashMap));
		return response;
	}
}
	