package com.tdd.sample;

/**
 * This interface provides a functionality to count words appearance.
 * */
public interface WordsCounter {

	/**
	 * Counts word appearance.
	 * 
	 * @param word
	 *            the word to count.
	 */
	void count(String word);

	/**
	 * Returns the word appearance number.
	 * 
	 * @param word
	 *            the word to count.
	 * 
	 * @return the number of word appearance.
	 */
	int getCount(String word);

}
