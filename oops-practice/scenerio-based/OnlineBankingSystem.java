package ScenarioBased;

import java.util.*;

//exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

//abstract class
abstract class Account {
    protected int accountNumber;
    protected double balance;
    protected List<String> transactions = new ArrayList<>();

    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }
        balance -= amount;
        transactions.add("Withdrawn: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactions() {
        for (String t : transactions) {
            System.out.println(t);
        }
    }

    // PolyMorphism
    public abstract double calculateInterest();
}

// subclass savings account
class SavingsAccount extends Account {

    public SavingsAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04; // 4% interest
    }
}

//subclass current account
class CurrentAccount extends Account {

    public CurrentAccount(int accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest
    }
}

//interface
interface BankService {
    void transfer(Account from, Account to, double amount) throws InsufficientBalanceException;
}

class BankServiceImpl implements BankService {

    @Override
    public void transfer(Account from, Account to, double amount) throws InsufficientBalanceException {
        from.withdraw(amount);
        to.deposit(amount);
    }
}

//MultiThreading
class TransactionThread extends Thread {
    private BankService bankService;
    private Account from;
    private Account to;
    private double amount;

    public TransactionThread(BankService bankService, Account from, Account to, double amount) {
        this.bankService = bankService;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            bankService.transfer(from, to, amount);
            System.out.println("Transfer Successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//main class
public class OnlineBankingSystem {

    public static void main(String[] args) {

        // Account creation
        Account acc1 = new SavingsAccount(101, 10000);
        Account acc2 = new CurrentAccount(102, 5000);

        BankService bankService = new BankServiceImpl();

        // Concurrent transactions
        Thread t1 = new TransactionThread(bankService, acc1, acc2, 2000);
        Thread t2 = new TransactionThread(bankService, acc1, acc2, 3000);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }

        // Balance check
        System.out.println("Final Balances:");
        System.out.println("Savings Account: " + acc1.getBalance());
        System.out.println("Current Account: " + acc2.getBalance());

        // PolyMorphism
        System.out.println("Savings Account Interest: "+ acc1.calculateInterest());

        // Transaction history
        System.out.println("Transaction History (Savings Account):");
        acc1.showTransactions();
    }
}