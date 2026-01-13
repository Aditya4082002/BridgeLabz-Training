package com.oops.digitalwallet;

class BankTransfer implements TransferService {

    @Override
    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {

        double bankCharge = 10;

        if (amount + bankCharge > from.getBalance()) {
            throw new InsufficientBalanceException("Insufficient balance including bank charges");
        }

        from.sendTransfer(amount + bankCharge);
        to.receiveTransfer(amount);
        System.out.println("Bank transfer successful: " + amount +
                " (Bank charge: " + bankCharge + ")");
    }
}