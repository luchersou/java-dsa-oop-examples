package org.example.OOP.Encapsulation;

public class BankAccount {
    private final String accountNumber; // read-only (immutable after constructor)
    private String owner;
    private double balance;

    public BankAccount(String accountNumber, String owner, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative.");
        }
        this.balance = initialDeposit;
    }

    // Public getter - no setter (accountNumber is immutable)
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter and setter for owner
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        if (owner == null || owner.isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty.");
        }
        this.owner = owner;
    }

    // Public getter for balance (no setter - modified via methods only)
    public double getBalance() {
        return balance;
    }

    // Business logic methods to modify internal state safely
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be greater than zero.");
        }
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal must be greater than zero.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }

        balance -= amount;
        return true;
    }
}
