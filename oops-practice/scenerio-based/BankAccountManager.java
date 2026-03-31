package scenrioBase;

class BankAccount {

    private long accountNumber;
    private double balance;

    BankAccount(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance = balance + amount;
        System.out.println("Amount deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal denied.");
        } else {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully.");
        }
    }

    public void checkBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

public class BankAccountManager {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1234567890L, 5000.0);

        account.checkBalance();
        account.deposit(2000.0);
        account.withdraw(3000.0);
        account.withdraw(6000.0);
        account.checkBalance();
    }
}
