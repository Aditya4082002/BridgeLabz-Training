package inheritance;


//class definition 
class BankAccount{
	//attributes
	protected long accountNumber;
	protected double balance;
	
	//constructor
	BankAccount(long accountNumber,double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public void displapAccountType(){
		System.out.println("Account Number : " + accountNumber);
		System.out.println("Balance : " + balance);
	}
}


//class definition 
class SavingsAccount extends BankAccount{
	//attributes
	protected double interestRate;
	
	//Constructor
	SavingsAccount(long accountNumber,double balance, double interestRate){
		super(accountNumber,balance);
		this.interestRate = interestRate;
	}
	
	@Override
	public void displapAccountType(){
		super.displapAccountType();
		System.out.println("Interest Rate : " + interestRate);
	}
}


//class definition 
class CheckingAccount extends BankAccount{
	//attributes
	protected double withdrawlLimit;
	
	CheckingAccount(long accountNumber,double balance, double withdrawlLimit){
		super(accountNumber,balance);
		this.withdrawlLimit = withdrawlLimit;
	}
	
	@Override
	public void displapAccountType(){
		super.displapAccountType();
		System.out.println("Withdrawl Limit : " + withdrawlLimit);
	}
}


//class definition 
class FixedDepositAccount extends BankAccount{
	//attributes
	protected double fixedBalance;
	
	//constructor
	FixedDepositAccount(long accountNumber,double balance,double fixedBalance){
		super(accountNumber,balance);
		this.fixedBalance = fixedBalance;
	}
	
	@Override
	public void displapAccountType(){
		super.displapAccountType();
		System.out.println("Fixed Balance : " + fixedBalance);
	}
}

public class Bank {

	public static void main(String[] args) {
		SavingsAccount savingsAccount1  = new SavingsAccount(10025465,20000,7.5);
		CheckingAccount checkingAccount1 = new CheckingAccount(125669845,30000,10000);
		FixedDepositAccount fixedDepositAccount1 = new FixedDepositAccount(445569854,26532,25000);
		
		savingsAccount1.displapAccountType();
		checkingAccount1.displapAccountType();
		fixedDepositAccount1.displapAccountType();
	}

}
