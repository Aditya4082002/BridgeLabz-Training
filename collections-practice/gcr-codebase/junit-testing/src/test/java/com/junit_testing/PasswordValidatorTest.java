package com.junit_testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    PasswordValidator validator = new PasswordValidator();

    //Valid passwords
    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("Java1234"));
        assertTrue(validator.isValid("Secure9A"));
    }

    //Too short
    @Test
    void testShortPassword() {
        assertFalse(validator.isValid("Abc12"));
    }

    //No uppercase
    @Test
    void testNoUppercase() {
        assertFalse(validator.isValid("password1"));
    }

    //No digit
    @Test
    void testNoDigit() {
        assertFalse(validator.isValid("Password"));
    }

    //Null input
    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}
