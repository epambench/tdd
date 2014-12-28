package com.tdd.sample;

import java.util.HashMap;
import java.util.Map;

public class WordsCounter {

	private final Map<String, Integer> wordsOccurence;

	public WordsCounter() {
		wordsOccurence = new HashMap<String, Integer>();
	}

	public void count(String word) {
		if (word != null) {
			int counter = 0;
			if (wordsOccurence.containsKey(word)) {
				counter = wordsOccurence.get(word);
			}
			wordsOccurence.put(word, ++counter);
		}
	}

	public Object getCount(String word) {
		return wordsOccurence.get(word) == null ? 0 : wordsOccurence.get(word);
	}
}
