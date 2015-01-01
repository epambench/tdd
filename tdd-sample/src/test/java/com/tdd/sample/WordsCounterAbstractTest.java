package com.tdd.sample;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class WordsCounterAbstractTest {

	public static final String TEST_WORD = "word";
	public static final String EMPTY_WORD = "";
	public static final String SPACE = " ";
	public static final String TEST_SYMBOL = "a";

	private WordsCounter wordsCounter;

	protected abstract WordsCounter makeWordsCounterInstance();

	@Before
	public void setUp() throws Exception {
		wordsCounter = makeWordsCounterInstance();
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
	public void testGetCountForEmptyCounter() {
		assertEquals(0, wordsCounter.getCount(null));
		assertEquals(0, wordsCounter.getCount(EMPTY_WORD));
		assertEquals(0, wordsCounter.getCount(SPACE));
		assertEquals(0, wordsCounter.getCount(TEST_WORD));
		assertEquals(0, wordsCounter.getCount(TEST_SYMBOL));
	}
	
	@Test
	public void testGetCountForEmptyWord() {
		getWordsCounter().count(" ");
		assertEquals(0, getWordsCounter().getCount(EMPTY_WORD));
		assertEquals(0, getWordsCounter().getCount(SPACE));
		assertEquals(0, getWordsCounter().getCount(TEST_WORD));
		assertEquals(0, getWordsCounter().getCount(TEST_SYMBOL));
		int counter = 4;
		for (int i = 0; i < counter; i++) {
			getWordsCounter().count(SPACE);
			getWordsCounter().count(EMPTY_WORD);
		}
		assertEquals(0, getWordsCounter().getCount(SPACE));
		assertEquals(0, getWordsCounter().getCount(EMPTY_WORD));
	}

	@Test
	public void testGetCountForDifferentWords() {
		getWordsCounter().count(TEST_WORD);
		getWordsCounter().count(TEST_WORD);
		assertEquals(2, getWordsCounter().getCount(TEST_WORD));
		getWordsCounter().count(" word");
		assertEquals(1, getWordsCounter().getCount(" word"));
		getWordsCounter().count(" word ");
		assertEquals(1, getWordsCounter().getCount(" word "));
		assertEquals(0, getWordsCounter().getCount("words"));
		getWordsCounter().count("ABCDEFGhijklmnopQrsTUvWxYz");
		assertEquals(1, getWordsCounter().getCount("ABCDEFGhijklmnopQrsTUvWxYz"));
	}

	@Test
	public void testGetCountForMultipleWords() {
		getWordsCounter().count("test word");
		getWordsCounter().count("test word");
		assertEquals(2, getWordsCounter().getCount("test word"));
		assertEquals(0, getWordsCounter().getCount("test"));
		assertEquals(0, getWordsCounter().getCount("test "));
		assertEquals(0, getWordsCounter().getCount(" test "));
		assertEquals(0, getWordsCounter().getCount("word"));
		assertEquals(0, getWordsCounter().getCount(" word"));
	}

	public WordsCounter getWordsCounter() {
		return wordsCounter;
	}

}
