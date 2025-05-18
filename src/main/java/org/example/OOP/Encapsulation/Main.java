package org.example.OOP.Encapsulation;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345678", "Lucas", 1000.0);

        System.out.println("Account Owner: " + account.getOwner());
        System.out.println("Initial Balance: " + account.getBalance());

        account.deposit(500);
        System.out.println("After Deposit: " + account.getBalance());

        if (account.withdraw(300)) {
            System.out.println("After Withdrawal: " + account.getBalance());
        }

        // Try invalid operations
        try {
            account.setOwner(""); // Throws exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            account.deposit(-50); // Throws exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

