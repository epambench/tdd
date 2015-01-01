package com.tdd.sample;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

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

	@Test
	public void testGetCountWithMockitoCounter() {
		String testWord = "test";
		WordsCounterImpl wordsCounterImpl = mock(WordsCounterImpl.class);
		WordsCounter proxyCounter = new WordsCounterProxy(wordsCounterImpl);
		when(wordsCounterImpl.getCount(testWord)).thenReturn(1);
		proxyCounter.count(testWord);
		verify(wordsCounterImpl).count(testWord);
		proxyCounter.getCount(testWord);
		verify(wordsCounterImpl).getCount(testWord);
	}
}
