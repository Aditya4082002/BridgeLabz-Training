package classanobject;

public class Bank {

	public static void main(String[] args) {
		BankAccount account1 = new BankAccount("Aditya",1000010101,10000);
		
		account1.deposite(500);
		account1.withdrawl(9500);
		account1.withdrawl(1500);
		
	}

}

//class definition
class BankAccount{
	//attributes
	private String accountHolder;
	private long accountNuber;
	private double balance;
	
	//constructor
	public BankAccount(String accountHolder,long accountNumber,double balance) {
		this.accountHolder = accountHolder;
		this.accountNuber = accountNumber;
		this.balance = balance;
	}
	
	//method for withdrawl
	public void withdrawl(double amount) {
		System.out.println("withdrawl amount : " + amount);
		if(balance>=amount) {
			balance-=amount;
			System.out.println("withdrawl Successfull");
			this.displayBalance();
		}else {
			System.out.println("Insufficient balance.");
			this.displayBalance();
		}
	}
	
	//method to deposite
	public void deposite(double amount) {
		this.balance += amount;
		System.out.println("deposite amount : " + amount);
		System.out.println("deposite Successfull");
		this.displayBalance();
	}
	
	//method to displayBalance
	public void displayBalance() {
		System.out.println("Current balance : " + balance);
	}
}
