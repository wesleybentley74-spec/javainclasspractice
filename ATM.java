/**
 * Wesley Bentley
 * CIST 211
 * Doctor G
 * 
 * Purpose: The purpose of this code is to demonstrate a sequence diagram example in Java. 
 * The ATM class interacts with a BankServer class to perform a withdrawal operation. 
 * The sequence of actions includes verifying the PIN, requesting funds, and dispensing cash 
 * if the transaction is successful
 * 
 */
public class ATM {
    private BankServer bankServer;

    public ATM(BankServer bankServer) {
        this.bankServer = bankServer;
    }

    /// startWithdrawal initiates the sequence of actions for a withdrawal request
    public void startWithdrawal(int pin, double amount) {
        System.out.println("[ATM] startWithdrawal(" + pin + ", " + amount + ")");

        //Verify PIN with BankServer
        System.out.println("Verifying PIN");
        if (!bankServer.verifyPIN(pin)) {
            System.out.println("Error: Invalid PIN");
            return; // stop sequence on bad PIN
        }

        // Request funds from BankServer
        System.out.println("Requesting $" + amount + " from bank");
        if (!bankServer.requestFunds(amount)) {
            System.out.println("Error: Insufficient funds");
            return; // stop sequence on insufficient funds
        }

        // Dispense cash locally after bank approves
        dispenseCash(amount);
        System.out.println("Withdrawal complete");
    }

    // dispenseCash simulates the dispensing of cash to the user
    private void dispenseCash(double amount) {
        System.out.println("Dispensing $" + amount + ". Please take your cash");
    }
}
