package com.tdd.sample;

import org.apache.commons.lang3.StringUtils;

/**
 * This class represents an implementation of <code>WordsCounter</code>
 * interface based on <code>WordsCounterImpl</code> class with different
 * behavior. This implementation calculates only alphabetic words.
 */
public class WordsCounterProxy implements WordsCounter {

	private WordsCounter wordsCounter;

	public WordsCounterProxy(WordsCounter wordsCounter) {
		this.wordsCounter = wordsCounter;
	}

	/**
	 * Return false if any character of incoming word is not alphabetic.
	 */
	private boolean isAlpha(String word) {
		char[] chars = word.toCharArray();
		for (char charr : chars) {
			if (charr != ' ' && !Character.isLetter(charr)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc} Only characters can be recognized as a word.
	 */
	public void count(String word) {
		if (!StringUtils.isBlank(word) && isAlpha(word)) {
			wordsCounter.count(word);
		}
	}

	public int getCount(String word) {
		return wordsCounter.getCount(word);
	}

}
