package concurrency_multithreaded_bank_account;

public class BankAccount {

    private static int counter = 1;

    private final int accountNumber;
    private double balance;

    public BankAccount(double initialBalance) {
        this.accountNumber = counter++;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public synchronized double getBalance() {
        return balance;
    }
}