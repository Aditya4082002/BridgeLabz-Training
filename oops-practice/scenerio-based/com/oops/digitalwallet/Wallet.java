package com.oops.digitalwallet;
import java.util.*;

class Wallet {
    private User user;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    Wallet(User user) {
        this.user = user;
        this.balance = 0;
    }

    public void addMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction("Credit", amount));
        System.out.println("Money added: " + amount);
    }

    public void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient wallet balance");
        }
        balance -= amount;
        transactions.add(new Transaction("Debit", amount));
        System.out.println("Money withdrawn: " + amount);
    }

    public void receiveTransfer(double amount) {
        balance += amount;
        transactions.add(new Transaction("Transfer In", amount));
    }

    public void sendTransfer(double amount) {
        balance -= amount;
        transactions.add(new Transaction("Transfer Out", amount));
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactions() {
        System.out.println("\nTransaction History for " + user.getName() + ":");
        for (Transaction t : transactions) {
            t.display();
        }
    }
}
