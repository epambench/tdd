package com.tdd.sample;

import java.util.HashMap;
import java.util.Map;

public class WordsCounter {

	private final Map<String, Integer> wordsOccurence;
	private String WORDS_DELIMITER = " ";

	public WordsCounter() {
		wordsOccurence = new HashMap<String, Integer>();
	}

	public void count(String word) {
		int counter = 0;
		if (wordsOccurence.containsKey(word)) {
			counter = wordsOccurence.get(word);
		}
		wordsOccurence.put(word, ++counter);
	}

	public Object getCount(String word) {
		return wordsOccurence.get(word) == null ? 0 : wordsOccurence.get(word);
	}
}
