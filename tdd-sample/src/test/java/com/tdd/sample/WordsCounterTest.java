package com.tdd.sample;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordsCounterTest {

	private WordsCounter wordsCounter;
	public static final String TEST_WORD = "word";
	public static final String EMPTY_WORD = "";
	public static final String SPACE = " ";
	public static final String TEST_SYMBOL = "a";

	@Before
	public void setUp() throws Exception {
		wordsCounter = new WordsCounter();
	}

	@Test
	public void testGetCountForNull() {
		wordsCounter.count(null);
		assertEquals(0, wordsCounter.getCount(null));
		assertEquals(0, wordsCounter.getCount(EMPTY_WORD));
		assertEquals(0, wordsCounter.getCount(SPACE));
		assertEquals(0, wordsCounter.getCount(TEST_WORD));
		assertEquals(0, wordsCounter.getCount(TEST_SYMBOL));		
	}

	@Test
	public void testGetCountForEmptyWord() {
		wordsCounter.count("");
		assertEquals(1, wordsCounter.getCount(EMPTY_WORD));
		assertEquals(0, wordsCounter.getCount(SPACE));
		assertEquals(0, wordsCounter.getCount(TEST_WORD));
		assertEquals(0, wordsCounter.getCount(TEST_SYMBOL));
		int counter = 4;
		for (int i = 0; i < counter; i++) {
			wordsCounter.count(SPACE);
		}
		assertEquals(counter, wordsCounter.getCount(SPACE));
	}

	@Test
	public void testGetCountForEmptyCounter() {
		assertEquals(0, wordsCounter.getCount(null));
		assertEquals(0, wordsCounter.getCount(EMPTY_WORD));
		assertEquals(0, wordsCounter.getCount(SPACE));
		assertEquals(0, wordsCounter.getCount(TEST_WORD));
		assertEquals(0, wordsCounter.getCount(TEST_SYMBOL));
	}

	@Test
	public void testGetCountForMultipleWords() {
		wordsCounter.count("test word");
		wordsCounter.count("test word");
		assertEquals(2, wordsCounter.getCount("test word"));
		assertEquals(0, wordsCounter.getCount("test"));
		assertEquals(0, wordsCounter.getCount("test "));
		assertEquals(0, wordsCounter.getCount(" test "));
		assertEquals(0, wordsCounter.getCount("word"));
		assertEquals(0, wordsCounter.getCount(" word"));
	}

	@Test
	public void testGetCountForDifferentWords() {
		wordsCounter.count(TEST_WORD);
		wordsCounter.count(TEST_WORD);
		assertEquals(2, wordsCounter.getCount(TEST_WORD));
		wordsCounter.count(" word");
		assertEquals(1, wordsCounter.getCount(" word"));
		wordsCounter.count(" word ");
		assertEquals(1, wordsCounter.getCount(" word "));
		assertEquals(0, wordsCounter.getCount("words"));		
	}
}
