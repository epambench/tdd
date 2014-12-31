package com.tdd.sample;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

public class WordsCounterImplTest extends WordsCounterAbstractTest {

	@Override
	protected WordsCounter makeWordsCounterInstance() {
		return new WordsCounterImpl();
	}
}
