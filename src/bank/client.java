package bank;

/**
 *
 * @author Josee
 */
public class client {

    private String name;
    private String email;
    private bank_acount account;

    // Constructor
    public client(String name, String email, bank_acount account) {
        this.name = name;
        this.email = email;
        this.account = account;
    }

    // Methods for banking operations with PIN validation
    public void depositToAccount(double amount, String enteredPin) {
        if (account.validatePin(enteredPin)) {
            account.deposit(amount, "Deposit");
        } else {
            System.out.println("Invalid PIN. Deposit failed.");
        }
    }

    public void withdrawFromAccount(double amount, String enteredPin) {
        if (account.validatePin(enteredPin)) {
            account.withdraw(amount, "Withdrawal");
        } else {
            System.out.println("Invalid PIN. Withdrawal failed.");
        }
    }

    public void checkBalance(String enteredPin) {
        if (account.validatePin(enteredPin)) {
            System.out.println("Current balance: $" + account.checkBalance());
        } else {
            System.out.println("Invalid PIN. Cannot check balance.");
        }
    }

    public void displayAccountInfo(String enteredPin) {
        if (account.validatePin(enteredPin)) {
            account.displayAccountInfo();
        } else {
            System.out.println("Invalid PIN. Cannot display account information.");
        }
    }
}
