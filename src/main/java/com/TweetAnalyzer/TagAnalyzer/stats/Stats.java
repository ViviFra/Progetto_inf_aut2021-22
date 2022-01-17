package com.TweetAnalyzer.TagAnalyzer.stats;

import java.util.ArrayList;
import java.util.Collections;

public class Stats{
	
	public int TotHash(ArrayList<String> hashtags) {		//ritorna il numero totale degli hashtag nei 100 post
		return (hashtags.size());
	}
	
	public int MediHash(ArrayList<String> hashtags, int num) {
		return (hashtags.size() / num);
	}
	

	private class quanti{									//classe di supporto per la stats sugli hashtag più frequenti

		String hashtag;
		int cont;
		
		public String getHashtag() {
			return hashtag;
		}

		public int getCont() {
			return cont;
		}

		
		public quanti(String hashtag, int cont) {
			this.hashtag = hashtag;
			this.cont = cont;
		}

	}
	


	//( int occorrenze = Collections.frequency(hashtags, hashtags.get(i)); )
	
	public quanti FrequezHash(ArrayList<String> hashtags) {
		quanti topHash = new quanti(null, 0);
		
		ArrayList<quanti> conthash = new ArrayList<quanti>();	//creo un ArrayList che accoglie l'hashtag e la sua ricorrenza nell'ArrayList
		
		for (short i = 0; i < hashtags.size(); i++) {
			quanti raw = new quanti( hashtags.get(i), Collections.frequency(hashtags, hashtags.get(i)) );
			conthash.add(raw);
			}
		
		for (short j = 0; j < conthash.size(); j++) {
			quanti sentinella = conthash.get(j);
			//String parola = sentinella.getHashtag();
			int conta = sentinella.getCont();
			
			for (int q = j+1; q<conthash.size()-j; q++) {
				
				quanti sentinella1 = conthash.get(q);
				//String parola1 = sentinella1.getHashtag();
				int conta1 = sentinella1.getCont();

				if (sentinella1 == sentinella || conta < conta1) continue;
				else topHash = sentinella;
			}
			

			
		}
		
		return topHash;
	}
	

	