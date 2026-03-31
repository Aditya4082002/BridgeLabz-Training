package com.oops.ecommerce;

class WalletPayment implements Payment {
	private int balance = 50000;
	
	public void pay(double amount) throws PaymentFailedException{
		if(amount <= 0) {
			throw new PaymentFailedException("Invalid amount.");
		}
		else if(amount > balance) {
			throw new PaymentFailedException("Insufficient balance.");
		}
		System.out.println("Wallet Payment Successful.");
	}
}
