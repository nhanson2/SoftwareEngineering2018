package edu.nd.se2018.homework.hwk1;
import java.util.Hashtable;
//Author: Nathaniel Hanson
//Date: 9/3/2018
public class Question2 {
	public Question2(){}
	public String getMostFrequentWord(String input, String stopwords){
		Hashtable<String, Integer> hashtable = new Hashtable<String, Integer>();
		int maxCount = 0;
		boolean nonUnique = false;
		String result = ""; 
		for(String word:input.split("\\s+")) {
			// If the word is not in the stop words block
			if(stopwords.indexOf(word)<0) {
				if(hashtable.containsKey(word)){
					hashtable.put(word,hashtable.get(word)+1);
				}
				// First time adding word to map
				else { 
					hashtable.put(word,1);
				}
				// Keep track if the maxCount value is not unique
				if(hashtable.get(word)==maxCount) {
					nonUnique = true;
				}
				if(hashtable.get(word)>maxCount){
					maxCount = hashtable.get(word);
					result = word;
					nonUnique = false;
				}
			}
		}
		if(nonUnique) { result = null; }
		return result;
	}
}
