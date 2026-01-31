package com.junit_testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {
	
	private NumberUtils numberUtils = new NumberUtils();
	
	@ParameterizedTest
	@ValueSource(ints= {2,4,6})
	void testIsEvenTrue(int number) {
		assertTrue(numberUtils.isEven(number));
	}
	
	@ParameterizedTest
	@ValueSource(ints= {3,5})
	void testIsEvenFalse(int number) {
		assertFalse(numberUtils.isEven(number));
	}
}
