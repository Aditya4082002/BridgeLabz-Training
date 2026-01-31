package com.junit_testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    MathUtils mathUtils = new MathUtils();

    @Test
    void testDivideByZeroThrowsException() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> mathUtils.divide(10, 0)
        );

        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    void testDivideSuccess() {
        assertEquals(5, mathUtils.divide(10, 2));
    }
}
