package com.tdd.sample;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class WordsCounterImpl implements WordsCounter {

	private final Map<String, Integer> wordsOccurence;

	public WordsCounterImpl() {
		wordsOccurence = new HashMap<String, Integer>();
	}

	/**
	 * {@inheritDoc}
	 *  Null, empty or blank strings are not calculated.
	 */
	public void count(String word) {
		if (!StringUtils.isBlank(word)) {
			int counter = 0;
			if (wordsOccurence.containsKey(word)) {
				counter = wordsOccurence.get(word);
			}
			wordsOccurence.put(word, ++counter);
		}
	}

	public int getCount(String word) {
		return wordsOccurence.get(word) == null ? 0 : wordsOccurence.get(word);
	}

}
