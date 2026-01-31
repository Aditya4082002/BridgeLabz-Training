package com.junit_testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    //Valid dates
    @Test
    void testValidDate() {
        assertEquals("25-12-2025",
                formatter.formatDate("2025-12-25"));

        assertEquals("01-01-2024",
                formatter.formatDate("2024-01-01"));
    }

    //Invalid format
    @Test
    void testInvalidFormat() {
        assertNull(formatter.formatDate("25/12/2025"));
    }

    //Invalid value
    @Test
    void testInvalidDateValue() {
        assertNull(formatter.formatDate("2025-13-40"));
    }

    //Null input
    @Test
    void testNullInput() {
        assertNull(formatter.formatDate(null));
    }
}
