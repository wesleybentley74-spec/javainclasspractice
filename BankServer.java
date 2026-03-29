/**
 * BankServer simulates a backend system that holds an account balance
 * and validates a PIN before releasing funds.
 */
public class BankServer {
    private double balance = 500.00;
    private final int correctPin = 1234;

    /**
     * Check whether supplied PIN matches the stored correct PIN.
     */
    public boolean verifyPIN(int pin) {
        System.out.println("[BankServer] verifyPIN(" + pin + ") called");
        return pin == correctPin;
    }

    public boolean requestFunds(double amount) {
        System.out.println("[BankServer] requestFunds(" + amount + ") called");
        if (amount <= balance) {
            balance -= amount;
            System.out.println("[BankServer] approved, new balance=" + balance);
            return true;
        }
        System.out.println("[BankServer] denied, insufficient funds (balance=" + balance + ")");
        return false;
    }

    public double getBalance() {
        return balance;
    }
}
