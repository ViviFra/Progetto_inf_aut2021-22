package com.TweetAnalyzer.TagAnalyzer.service;

//questa interfaccia contiene metodi astratti relativi alla gestione di dati e metadati

import org.json.JSONObject;

public interface TweetDataInterface {

	public abstract JSONObject seeMetaData();

	public abstract JSONObject seeData(String tag);


}
