package com.TweetAnalyzer.TagAnalyzer.service;

public class ApiCall implements ApiCallInterface{
	
	private static final String apidefvalue = "https://api.twitter.com/2/users/";
	private String apifinal;
	private String idtopass;
	private int num;
	
	public ApiCall(String apifinal, String idtopass, int num) {
		super();
		this.apifinal = apifinal;
		this.idtopass = idtopass;
		this.num = num;
	}
	
	@Override
	public String Buildapi() throws WrongNumofPostException {

		if (num>5||num>100) {
			
			apifinal = apidefvalue + idtopass + "/tweets?max_results="+ num + "&tweet.fields=entities";
			}
			
	
		else { 
			throw new WrongNumofPostException ("ERROR: post number mus be between 5 and 100");
		} 
		return apifinal;
	}
	
	

}
