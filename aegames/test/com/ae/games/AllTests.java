package com.ae.games;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ae.games.service.PokerGameServiceTest;
import com.ae.games.service.PokerValidationServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
	PokerValidationServiceTest.class,
	PokerGameServiceTest.class
})
public class AllTests {

}
