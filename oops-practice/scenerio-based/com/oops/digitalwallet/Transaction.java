package com.oops.digitalwallet;

class Transaction {
    private String type;
    private double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public void display() {
        System.out.println(type + " : " + amount);
    }
}