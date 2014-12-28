package com.tdd.sample;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordsCounterTest {

	private WordsCounter wordsCounter;

	@Before
	public void setUp() throws Exception {
		wordsCounter = new WordsCounter();
	}
	
	@Test
	public void testGetCountForNull() {
		wordsCounter.count(null);
		assertEquals(0, wordsCounter.getCount(null));
		assertEquals(0, wordsCounter.getCount(""));
		assertEquals(0, wordsCounter.getCount(" "));
		assertEquals(0, wordsCounter.getCount("word"));
	}

	@Test
	public void testGetCountForEmptyWord() {
		wordsCounter.count("");
		assertEquals(1, wordsCounter.getCount(""));
		assertEquals(0, wordsCounter.getCount(" "));
		assertEquals(0, wordsCounter.getCount("word"));
		wordsCounter.count(" ");
		wordsCounter.count(" ");
		wordsCounter.count(" ");
		assertEquals(3, wordsCounter.getCount(" "));
	}

	@Test
	public void testGetCountForEmptyCounter() {
		assertEquals(0, wordsCounter.getCount(null));
		assertEquals(0, wordsCounter.getCount(""));
		assertEquals(0, wordsCounter.getCount(" "));
		assertEquals(0, wordsCounter.getCount("word"));
	}
	
	@Test
	public void testGetCountForMultipleWords() {
		wordsCounter.count("test word");
		wordsCounter.count("test word");
		assertEquals(2, wordsCounter.getCount("test word"));
		assertEquals(0, wordsCounter.getCount("test"));
		assertEquals(0, wordsCounter.getCount("test "));
		assertEquals(0, wordsCounter.getCount("word"));
		assertEquals(0, wordsCounter.getCount(" word"));
	}

	@Test
	public void testGetCountForDifferentWords() {
		wordsCounter.count("word");
		wordsCounter.count("word");
		wordsCounter.count(" word");
		wordsCounter.count(" word ");
		assertEquals(2, wordsCounter.getCount("word"));
		assertEquals(0, wordsCounter.getCount("words"));
		assertEquals(1, wordsCounter.getCount(" word"));
		assertEquals(1, wordsCounter.getCount(" word "));
	}
}

