package functionalinterface;

interface PaymentMethod {

    void pay(double amount);
}

class UpiPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

class CreditCardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

class WalletPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Wallet");
    }
}


public class DigitalPaymentGateway {

    public static void main(String[] args) {

        PaymentMethod[] payments = {
            new UpiPayment(),
            new CreditCardPayment(),
            new WalletPayment()
        };

        for (PaymentMethod payment : payments) {
            payment.pay(1500.00);
        }
    }
}

