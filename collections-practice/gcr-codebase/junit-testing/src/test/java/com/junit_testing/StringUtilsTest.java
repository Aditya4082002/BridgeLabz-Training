package com.junit_testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
	StringUtils stringUtils;
    
	@BeforeEach
	void setup() {
		stringUtils = new StringUtils();		
	}

    @Test
    void testReverse() {
        assertEquals("avaJ", stringUtils.reverse("Java"));
    }

    @Test
    void testIsPalindromeTrue() {
        assertTrue(stringUtils.isPalindrome("madam"));
    }

    @Test
    void testIsPalindromeFalse() {
        assertFalse(stringUtils.isPalindrome("java"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
    }

    // Optional edge cases (exam bonus)
    @Test
    void testReverseNull() {
        assertNull(stringUtils.reverse(null));
    }

    @Test
    void testToUpperCaseNull() {
        assertNull(stringUtils.toUpperCase(null));
    }
}
