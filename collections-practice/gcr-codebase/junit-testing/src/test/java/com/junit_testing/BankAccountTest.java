package com.junit_testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000); // starting balance
    }

    @Test
    void testDeposit() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testWithdraw() {
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    void testInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(2000);
        });
    }

    @Test
    void testNegativeDeposit() {
        assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-100);
        });
    }
}
