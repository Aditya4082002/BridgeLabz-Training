package oopsPillars;

// interface
interface Loanable {

    void applyForLoan(double amount);

    boolean calculateLoanEligibility();
}

// abstract class
abstract class BankAccount {

    private long accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(long accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance = balance + amount;
        System.out.println("Deposit successful.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance = balance - amount;
            System.out.println("Withdrawal successful.");
        }
    }

    public abstract double calculateInterest();

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount implements Loanable {

    private double loanAmount;

    public SavingsAccount(long accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    public void applyForLoan(double amount) {
        this.loanAmount = amount;
        System.out.println("Loan application submitted for Savings Account.");
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 50000;
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount implements Loanable {

    private double loanAmount;

    public CurrentAccount(long accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.02;
    }

    public void applyForLoan(double amount) {
        this.loanAmount = amount;
        System.out.println("Loan application submitted for Current Account.");
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 100000;
    }
}

// main class
public class BankingSystem {

    public static void processAccounts(BankAccount[] accounts) {

        for (BankAccount account : accounts) {

            double interest = account.calculateInterest();

            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getHolderName());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Interest: " + interest);

            if (account instanceof Loanable) {
                boolean eligible = ((Loanable) account).calculateLoanEligibility();
                System.out.println("Loan Eligible: " + eligible);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        BankAccount account1 =
            new SavingsAccount(101001, "Aditya", 60000);

        BankAccount account2 =
            new CurrentAccount(202002, "Rohit", 120000);

        account1.deposit(5000);
        account2.withdraw(20000);

        BankAccount[] accounts = { account1, account2 };

        processAccounts(accounts);
    }
}
