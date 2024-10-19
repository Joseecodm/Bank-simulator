package bank;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Josee
 */
public class bank_acount {

    private String accountNumber;
    private double balance;
    private String accountHolder;
    private String pin;  // 4-digit PIN for account security

    // Constructor
    public bank_acount(String accountNumber, String accountHolder, double initialBalance, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.pin = pin;  // Set the 4-digit PIN when account is created
    }

    // Method to check the PIN
    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    // Method to check the balance
    public double checkBalance() {
        return balance;
    }

    // Method to deposit money and generate ticket
    public void deposit(double amount, String transactionType) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
            generateTicket(amount, transactionType);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    // Method to withdraw money and generate ticket
    public void withdraw(double amount, String transactionType) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
            generateTicket(amount, transactionType);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Method to generate a transaction ticket and open it
    private void generateTicket(double amount, String transactionType) {
        String fileName = "transaction_ticket.txt";
        try {
            try ( // Create or overwrite the file
                    FileWriter writer = new FileWriter(fileName)) {
                writer.write("----- TRANSACTION TICKET -----\n");
                writer.write("Account Holder: " + accountHolder + "\n");
                writer.write("Account Number: " + accountNumber + "\n");
                writer.write("Transaction Type: " + transactionType + "\n");
                writer.write("Amount: $" + amount + "\n");
                writer.write("New Balance: $" + balance + "\n");
                writer.write("-------------------------------\n");
            }
            System.out.println("Transaction ticket generated.");

            // Open the file automatically after generating it
            openTicket(fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while generating the transaction ticket.");
        }
    }

    // Method to open the ticket file in Windows using the default text editor (Notepad)
    private void openTicket(String fileName) {
        try {
            Runtime.getRuntime().exec("notepad.exe " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while opening the transaction ticket.");
        }
    }

    // Method to display account information
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}
