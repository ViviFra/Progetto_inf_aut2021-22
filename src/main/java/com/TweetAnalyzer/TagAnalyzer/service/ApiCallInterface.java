package com.TweetAnalyzer.TagAnalyzer.service;

import java.util.ArrayList;

import com.TweetAnalyzer.TagAnalyzer.exception.NoDataException;
import com.TweetAnalyzer.TagAnalyzer.exception.WrongNumOfPostException;
import com.TweetAnalyzer.TagAnalyzer.model.Tweet;

public interface ApiCallInterface {

	public abstract String buildApiurl() throws WrongNumOfPostException;

	public abstract String saveTweets() throws NoDataException, WrongNumOfPostException;

	public abstract ArrayList<Tweet> getTweets();

}
