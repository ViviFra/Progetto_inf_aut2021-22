package com.TweetAnalyzer.TagAnalyzer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TweetAnalyzer.TagAnalyzer.exception.NoDataException;
import com.TweetAnalyzer.TagAnalyzer.exception.WrongNumOfPostException;
import com.TweetAnalyzer.TagAnalyzer.service.ApiCall;
import com.TweetAnalyzer.TagAnalyzer.service.TweetData;
import com.TweetAnalyzer.TagAnalyzer.stats.Stats;

// classe utilizzata per la gestione delle rotte

@RestController
public class Controller {

	ApiCall call;
	
	// rotta GET che salva i "max_results" tweet dell'utente richiesto "id"

	@GetMapping(value = "/tweet/get/timeline")
	public ResponseEntity<Object> getData(@RequestParam(name = "id") String idtopass,
			@RequestParam(name = "max_results") int num) throws NoDataException, WrongNumOfPostException {
		call = new ApiCall(idtopass, num);
		return new ResponseEntity<>(call.saveTweets(), HttpStatus.OK);
	}
	
	// rotta GET che ci mostra i metadati con i quali andremo a lavorare

	@GetMapping(value = "/tweet/metadata")
	public ResponseEntity<Object> seeMeta() {
		TweetData meta = new TweetData();
		return new ResponseEntity<>(meta.seeMetaData().toString(), HttpStatus.OK);
	}

	// rotta GET che ci mostra i dati precedentemente salvati sui quali andremo a lavorare
	
	@GetMapping(value = "/tweet/data")
	public ResponseEntity<Object> seeData() {
		if (call == null) {
			return new ResponseEntity<>("ERROR: first contact http://localhost:8080/tweet/get/timeline",
					HttpStatus.BAD_REQUEST);
		}
		TweetData data = new TweetData(call.getTweets());
		return new ResponseEntity<>(data.seeData(null).toString(), HttpStatus.OK);
	}
	
	// rotta GET che ci mostra le statistiche sui tweet salvati

	@GetMapping(value = "/tweet/tag/stats")
	public ResponseEntity<Object> seeStats() {
		if (call == null) {
			return new ResponseEntity<>("ERROR: first contact http://localhost:8080/tweet/get/timeline",
					HttpStatus.BAD_REQUEST);
		}
		TweetData data = new TweetData(call.getTweets());
		Stats stats = new Stats(data.seeData(null));
		return new ResponseEntity<>(stats.seeStats().toString(), HttpStatus.OK);
	}
	
	// rotta GET che ci restituisce i tweet con un determinato "tag"

	@GetMapping(value = "/tweet/data/tag/filter")
	public ResponseEntity<Object> filterTag(@RequestParam(name = "tag") String tag) {
		if (call == null) {
			return new ResponseEntity<>("ERROR: first contact http://localhost:8080/tweet/get/timeline",
					HttpStatus.BAD_REQUEST);
		}
		TweetData data = new TweetData(call.getTweets());
		return new ResponseEntity<>(data.seeData(tag).toString(), HttpStatus.OK);
	}

}
