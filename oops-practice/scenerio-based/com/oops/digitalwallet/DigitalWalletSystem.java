package com.oops.digitalwallet;

public class DigitalWalletSystem {

    public static void main(String[] args) {

        User u1 = new User(1, "Aditya");
        User u2 = new User(2, "Rahul");

        Wallet w1 = new Wallet(u1);
        Wallet w2 = new Wallet(u2);

        w1.addMoney(2000);

        try {
            w1.withdrawMoney(500);

            TransferService walletTransfer = new WalletTransfer();
            walletTransfer.transfer(w1, w2, 700);

            TransferService bankTransfer = new BankTransfer();
            bankTransfer.transfer(w1, w2, 500);

        } catch (InsufficientBalanceException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }

        System.out.println("\nBalance of " + u1.getName() + ": " + w1.getBalance());
        System.out.println("Balance of " + u2.getName() + ": " + w2.getBalance());

        w1.showTransactions();
        w2.showTransactions();
    }
}
