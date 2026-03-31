package multithreading;

import java.time.LocalDateTime;

class BankAccount {

    private int balance = 10000;

    public int getBalance() {
        return balance;
    }

    public boolean withdraw(String customerName, int amount) {

        if (balance >= amount) {
            System.out.println("[" + customerName + "] Processing withdrawal of " + amount);

            // Simulate processing delay
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;
            System.out.println("Transaction successful: " + customerName +
                    ", Amount: " + amount +
                    ", Remaining Balance: " + balance +
                    ", Time: " + LocalDateTime.now());
            return true;
        } else {
            System.out.println("Transaction failed: " + customerName +
                    ", Insufficient balance. Current Balance: " + balance);
            return false;
        }
    }
}

class Transaction implements Runnable {

    private BankAccount account;
    private String customerName;
    private int amount;

    public Transaction(BankAccount account, String customerName, int amount) {
        this.account = account;
        this.customerName = customerName;
        this.amount = amount;
    }

    @Override
    public void run() {

        System.out.println("Thread State Before Execution: " +
                Thread.currentThread().getName() + " - " +
                Thread.currentThread().getState());

        System.out.println("[" + customerName + "] Attempting to withdraw " + amount);

        account.withdraw(customerName, amount);
    }
}

public class BankingSystem {

    public static void main(String[] args) throws InterruptedException {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(new Transaction(account, "Customer-1", 3000), "ATM-1");
        Thread t2 = new Thread(new Transaction(account, "Customer-2", 4000), "ATM-2");
        Thread t3 = new Thread(new Transaction(account, "Customer-3", 2000), "ATM-3");
        Thread t4 = new Thread(new Transaction(account, "Customer-4", 5000), "ATM-4");
        Thread t5 = new Thread(new Transaction(account, "Customer-5", 1500), "ATM-5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("Final Account Balance: " + account.getBalance());
    }
}
