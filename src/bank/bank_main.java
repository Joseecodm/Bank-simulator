package bank;

import java.util.Scanner;

/**
 *
 * @author Josee
 */
public class bank_main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Changed Scanner object name to "sc"

        // Prompt user to create an account
        System.out.println("Welcome to the Bank!");
        System.out.println("Please create your account.");

        // Get account details from user
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your email: ");
        String email = sc.nextLine();
        System.out.print("Enter an initial deposit: ");
        double initialDeposit = sc.nextDouble();
        sc.nextLine();  // Consume newline
        System.out.print("Set a 4-digit PIN for your account: ");
        String pin = sc.nextLine();

        // Create bank account and client
        String accountNumber = "ACC" + (int) (Math.random() * 1000000);  // Generate random account number
        bank_acount newAccount = new bank_acount(accountNumber, name, initialDeposit, pin);
        client client = new client(name, email, newAccount);

        // Main menu for banking operations
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Show Account Info");
            System.out.println("5. Exit");

            int option = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter your 4-digit PIN: ");
                    String pinCheckBalance = sc.nextLine();
                    client.checkBalance(pinCheckBalance);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    sc.nextLine();  // Consume newline
                    System.out.print("Enter your 4-digit PIN: ");
                    String pinDeposit = sc.nextLine();
                    client.depositToAccount(depositAmount, pinDeposit);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    sc.nextLine();  // Consume newline
                    System.out.print("Enter your 4-digit PIN: ");
                    String pinWithdraw = sc.nextLine();
                    client.withdrawFromAccount(withdrawAmount, pinWithdraw);
                    break;
                case 4:
                    System.out.print("Enter your 4-digit PIN: ");
                    String pinAccountInfo = sc.nextLine();
                    client.displayAccountInfo(pinAccountInfo);
                    break;
                case 5:
                    System.out.println("Thank you for banking with us. Goodbye!");
                    sc.close();
                    return;  // Exit the program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}