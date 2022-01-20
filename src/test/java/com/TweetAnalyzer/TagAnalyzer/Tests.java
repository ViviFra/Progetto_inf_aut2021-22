package com.TweetAnalyzer.TagAnalyzer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.TweetAnalyzer.TagAnalyzer.exception.NoDataException;
import com.TweetAnalyzer.TagAnalyzer.exception.WrongNumOfPostException;
import com.TweetAnalyzer.TagAnalyzer.service.ApiCall;
import com.TweetAnalyzer.TagAnalyzer.service.TweetData;

//classe di test per metodi e eccezioni

@SpringBootTest
public class Tests {

	private ApiCall urlApiCall, excpApiCall1, excpApiCall2, nodataApiCall;
	private TweetData td;

	@BeforeEach
	void initialize() throws Exception {
		urlApiCall = new ApiCall("270839361", 100);
		excpApiCall1 = new ApiCall("270839361", 4);
		excpApiCall2 = new ApiCall("270839361", 101);
		nodataApiCall = new ApiCall("1467891951814983682", 100);
		td = new TweetData();
	}

	@AfterEach
	void destroy() throws Exception {
	}

	//test sulla corretta composizione dell'url
	
	@Test
	@DisplayName("Controllo correttezza url")
	void testUrl() throws WrongNumOfPostException {
		assertEquals(urlApiCall.buildApiurl(),
				"https://api.twitter.com/2/users/270839361/tweets?tweet.fields=entities&exclude=retweets,replies&max_results=100");
	}

	//test sulla corretta visualizzazione di metadati
	
	@Test
	@DisplayName("Controllo correttezza metadati")
	void testMetadata() {
		assertEquals(td.seeMetaData().toString(),
				"{\"list\":{\"tweet\":{\"hashtags\":\"ArrayList<String>\",\"text\":\"String\",\"id\":\"long\"}}}");
	}

	//test sull'eccezione relativa al numero di post passati come parametro, per difetto o eccesso
	
	@Test
	@DisplayName("Controllo correttezza WrongNumOfPostException")
	void testWNOPE() throws WrongNumOfPostException {
		try {
			excpApiCall1.buildApiurl();
			fail("No WrongNumOfPostException generated!");
		} catch (WrongNumOfPostException e) {
			assertThatExceptionOfType(WrongNumOfPostException.class);
		}

		try {
			excpApiCall2.buildApiurl();
			fail("No WrongNumOfPostException generated!");
		} catch (WrongNumOfPostException e) {
			assertThatExceptionOfType(WrongNumOfPostException.class);
		}
	}

	//test sull'eccezione relativa ad account senza contenuti propri
	
	@Test
	@DisplayName("Controllo correttezza IsEmptyException")
	void testIEE() throws NoDataException {
		try {
			nodataApiCall.saveTweets();
			fail("No IsEmptyException generated!");
		} catch (NoDataException | WrongNumOfPostException e) {
			assertThatExceptionOfType(NoDataException.class);
		}

	}

}