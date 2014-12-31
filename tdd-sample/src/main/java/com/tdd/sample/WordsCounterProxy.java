package com.tdd.sample;

import org.apache.commons.lang3.StringUtils;

public class WordsCounterProxy implements WordsCounter {

	private WordsCounter wordsCounter;

	public WordsCounterProxy(WordsCounter wordsCounter) {
		this.wordsCounter = wordsCounter;
	}

	public void count(String word) {
		if (!StringUtils.isBlank(word) && isAlpha(word)) {
			wordsCounter.count(word);
		}
	}

	private boolean isAlpha(String word) {
		char[] chars = word.toCharArray();
		for (char charr : chars) {
			if (charr != ' ' && !Character.isLetter(charr)) {
				return false;
			}
		}
		return true;
	}

	public int getCount(String word) {
		return wordsCounter.getCount(word);
	}

}
