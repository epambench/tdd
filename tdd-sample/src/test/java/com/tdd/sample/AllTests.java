package com.tdd.sample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ WordsCounterImplTest.class, WordsCounterProxyTest.class })
public class AllTests {

}
