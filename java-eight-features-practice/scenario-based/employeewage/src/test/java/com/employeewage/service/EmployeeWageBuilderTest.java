package com.employeewage.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeWageBuilderTest {

    private EmpWageBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new EmpWageBuilder();
    }

    // Test Valid Company
    @Test
    void testAddValidCompany() {

        assertDoesNotThrow(() ->
                builder.addCompany("TCS", 20, 20, 100));
    }

    // Test Invalid Company Name
    @Test
    void testInvalidCompanyName() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> builder.addCompany("TCS123", 20, 20, 100)
        );

        assertEquals("Invalid Company Name", exception.getMessage());
    }

    
    // Test Wage Computation
    @Test
    void testComputeWage() {

        builder.addCompany("Wipro", 20, 20, 100);
        builder.computeWages();

        int totalWage = builder.getTotalWage("Wipro");

        assertTrue(totalWage >= 0);
    }
}