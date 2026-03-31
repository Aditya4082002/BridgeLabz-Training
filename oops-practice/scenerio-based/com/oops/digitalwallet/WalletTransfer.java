package com.oops.digitalwallet;

class WalletTransfer implements TransferService {

    @Override
    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {

        if (amount > from.getBalance()) {
            throw new InsufficientBalanceException("Insufficient balance for transfer");
        }

        from.sendTransfer(amount);
        to.receiveTransfer(amount);
        System.out.println("Wallet transfer successful: " + amount);
    }
}

