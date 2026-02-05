package functionalinterface;

interface PaymentProcessor {

    void processPayment(double amount);

    default void refund(double amount) {
        System.out.println("Refund of ₹" + amount + " processed using standard flow");
    }
}


class UpiProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("UPI payment of ₹" + amount + " processed");
    }
}


class CreditCardProcessor implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Credit Card payment of ₹" + amount + " processed");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Credit Card refund of ₹" + amount + " processed");
    }
}


public class PaymentGateway {

    public static void main(String[] args) {

        PaymentProcessor upi = new UpiProcessor();
        PaymentProcessor card = new CreditCardProcessor();

        upi.processPayment(2000);
        upi.refund(500);

        System.out.println();

        card.processPayment(3000);
        card.refund(1000);
    }
}
