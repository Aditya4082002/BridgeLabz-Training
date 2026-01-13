package com.oops.ecommerce;

class PaymentFailedException extends Exception {
	public PaymentFailedException(String message) {
        super(message);
    }
}