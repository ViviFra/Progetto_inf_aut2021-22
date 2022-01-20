package com.TweetAnalyzer.TagAnalyzer.service;

//questa interfaccia contiene metodi astratti relativi all'utilizzo dell'API e salvataggio dati

import java.util.ArrayList;

import com.TweetAnalyzer.TagAnalyzer.exception.NoDataException;
import com.TweetAnalyzer.TagAnalyzer.exception.WrongNumOfPostException;
import com.TweetAnalyzer.TagAnalyzer.model.Tweet;

public interface ApiCallInterface {

	public abstract String buildApiurl() throws WrongNumOfPostException;

	public abstract String saveTweets() throws NoDataException, WrongNumOfPostException;

	public abstract ArrayList<Tweet> getTweets();

}
