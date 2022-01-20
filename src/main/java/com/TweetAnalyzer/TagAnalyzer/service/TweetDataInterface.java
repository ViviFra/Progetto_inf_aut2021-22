package com.TweetAnalyzer.TagAnalyzer.service;

import org.json.JSONObject;

public interface TweetDataInterface {

	public abstract JSONObject seeMetaData();

	public abstract JSONObject seeData(String tag);


}
