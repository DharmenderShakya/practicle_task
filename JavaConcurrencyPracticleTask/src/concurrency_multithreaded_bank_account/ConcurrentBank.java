package concurrency_multithreaded_bank_account;


import java.util.ArrayList;
import java.util.List;

public class ConcurrentBank {

    private final List<BankAccount> accounts = new ArrayList<>();

    // Create account and return object (as your main expects)
    public synchronized BankAccount createAccount(double initialBalance) {
        BankAccount account = new BankAccount(initialBalance);
        accounts.add(account);
        return account;
    }

    // Transfer using account objects
    public void transfer(BankAccount from, BankAccount to, double amount) {

        // Deadlock prevention using account number ordering
        BankAccount first = from.getAccountNumber() < to.getAccountNumber() ? from : to;
        BankAccount second = from.getAccountNumber() < to.getAccountNumber() ? to : from;

        synchronized (first) {
            synchronized (second) {

                if (from.withdraw(amount)) {
                    to.deposit(amount);
                    System.out.println("Transferred " + amount +
                            " from " + from.getAccountNumber() +
                            " to " + to.getAccountNumber());
                } else {
                    System.out.println("Transfer failed due to insufficient balance");
                }
            }
        }
    }

    public double getTotalBalance() {
        double total = 0;

        synchronized (accounts) {
            for (BankAccount acc : accounts) {
                total += acc.getBalance();
            }
        }

        return total;
    }
}