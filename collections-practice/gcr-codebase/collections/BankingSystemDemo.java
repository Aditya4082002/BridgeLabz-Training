package collections;
import java.util.*;

class WithdrawalRequest {
    private final String accountNumber;
    private final double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
}

class BankingSystem {

    // HashMap: AccountNumber -> Balance
    private final Map<String, Double> accounts = new HashMap<>();

    // Queue: Withdrawal requests FIFO
    private final Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Create account
    public void createAccount(String accountNumber, double initialBalance) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        accounts.put(accountNumber, initialBalance);
    }

    // Deposit money
    public void deposit(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be > 0");
        }

        accounts.put(accountNumber, accounts.get(accountNumber) + amount);
    }

    // Add withdrawal request to queue
    public void requestWithdrawal(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account not found: " + accountNumber);
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be > 0");
        }

        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
    }

    // Process withdrawal requests
    public void processWithdrawals() {
        System.out.println("---- Processing Withdrawals ----");

        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            String accNo = req.getAccountNumber();
            double amount = req.getAmount();

            double balance = accounts.get(accNo);

            if (balance >= amount) {
                accounts.put(accNo, balance - amount);
                System.out.println("Withdrawal Success: " + accNo + " withdrew " + amount);
            } else {
                System.out.println("Withdrawal Failed (Insufficient Balance): " + accNo +
                        " requested " + amount + ", balance = " + balance);
            }
        }
    }

    // Display all accounts (HashMap order)
    public void displayAccounts() {
        System.out.println("---- Accounts (HashMap) ----");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + " | Balance: " + entry.getValue());
        }
    }

    // TreeMap sorting by balance (Balance -> List of AccountNumbers)
    public void displayAccountsSortedByBalance() {
        System.out.println("---- Accounts Sorted by Balance (TreeMap) ----");

        TreeMap<Double, List<String>> sortedMap = new TreeMap<>();

        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            String accNo = entry.getKey();
            double balance = entry.getValue();

            sortedMap.putIfAbsent(balance, new ArrayList<>());
            sortedMap.get(balance).add(accNo);
        }

        for (Map.Entry<Double, List<String>> entry : sortedMap.entrySet()) {
            double balance = entry.getKey();

            for (String accNo : entry.getValue()) {
                System.out.println("Account: " + accNo + " | Balance: " + balance);
            }
        }
    }
}

public class BankingSystemDemo {
    public static void main(String[] args) {

        BankingSystem bank = new BankingSystem();

        // Create Accounts (HashMap)
        bank.createAccount("ACC101", 5000);
        bank.createAccount("ACC102", 2000);
        bank.createAccount("ACC103", 8000);

        // Deposit
        bank.deposit("ACC102", 1000);

        // Add withdrawal requests (Queue)
        bank.requestWithdrawal("ACC101", 1000);
        bank.requestWithdrawal("ACC102", 5000); // should fail
        bank.requestWithdrawal("ACC103", 2000);

        bank.displayAccounts();
        System.out.println();

        bank.processWithdrawals();
        System.out.println();

        bank.displayAccounts();
        System.out.println();

        bank.displayAccountsSortedByBalance();
    }
}
