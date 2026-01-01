package javaConstructors;

//Base class
class BankAccount {

 // Access modifiers
 public long accountNumber;        // public
 protected String accountHolder;   // protected
 private double balance;            // private

 // Constructor
 BankAccount(long accountNumber, String accountHolder, double balance) {
     this.accountNumber = accountNumber;
     this.accountHolder = accountHolder;
     this.balance = balance;
 }

 // Getter for balance
 public double getBalance() {
     return balance;
 }

 // Setter / modifier for balance
 public void setBalance(double balance) {
     if (balance >= 0) {
         this.balance = balance;
     } else {
         System.out.println("Balance cannot be negative");
     }
 }

 // Deposit method
 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
     }
 }

 // Withdraw method
 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
     } else {
         System.out.println("Invalid withdrawal amount");
     }
 }

 // Display account details
 public void displayAccountDetails() {
     System.out.println("Account Number: " + accountNumber);
     System.out.println("Account Holder: " + accountHolder);
     System.out.println("Balance: ₹" + balance);
 }
}

//Subclass
class SavingsAccount extends BankAccount {

 double interestRate;

 SavingsAccount(long accountNumber, String accountHolder, double balance, double interestRate) {
     super(accountNumber, accountHolder, balance);
     this.interestRate = interestRate;
 }

 // Demonstrating access to public and protected members
 void displaySavingsAccountDetails() {
     System.out.println("Account Number: " + accountNumber);      // public
     System.out.println("Account Holder: " + accountHolder);      // protected
     System.out.println("Balance: ₹" + getBalance());             // private via getter
     System.out.println("Interest Rate: " + interestRate + "%");
 }

 // Main method
 public static void main(String[] args) {

     SavingsAccount savingsaccount = new SavingsAccount(1234567890L, "Aditya Singh", 25000, 4.5);

     savingsaccount.displayAccountDetails();
     System.out.println();

     // Modify balance using public methods
     savingsaccount.deposit(5000);
     savingsaccount.withdraw(3000);

     savingsaccount.displaySavingsAccountDetails();
 }
}
