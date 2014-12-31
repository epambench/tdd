package com.tdd.sample;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class WordsCounterProxyTest extends WordsCounterAbstractTest {

	@Override
	protected WordsCounter makeWordsCounterInstance() {
		return new WordsCounterProxy(new WordsCounterImpl());
	}

	@Test
	public void testGetCountForNotWords() {
		getWordsCounter().count(",.");
		assertEquals(0, getWordsCounter().getCount(",."));
		getWordsCounter().count("1234");
		assertEquals(0, getWordsCounter().getCount("1234"));
		getWordsCounter().count("1,2.3");
		assertEquals(0, getWordsCounter().getCount("1,2.3"));
		getWordsCounter().count("!@#$%^&*()");
		assertEquals(0, getWordsCounter().getCount("!@#$%^&*()"));
		getWordsCounter().count("<>+_=|/");
		assertEquals(0, getWordsCounter().getCount("<>+_=|/"));
		getWordsCounter().count(",.");
		assertEquals(0, getWordsCounter().getCount(",."));
	}
}
