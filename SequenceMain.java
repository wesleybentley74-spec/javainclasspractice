/**
 * SequenceMain demonstrates the ATM and BankServer interaction
 */
public class SequenceMain {
    public static void main(String[] args) {
        BankServer bankServer = new BankServer();
        ATM atm = new ATM(bankServer);

        System.out.println("-- scenario 1: successful withdrawal --");
        atm.startWithdrawal(1234, 100.00);

        System.out.println("\n-- scenario 2: invalid PIN --");
        atm.startWithdrawal(9999, 100.00);

        System.out.println("\n-- scenario 3: insufficient funds --");
        atm.startWithdrawal(1234, 1000.00);

        System.out.println("\nFinal bank balance: $" + bankServer.getBalance());
    }
}
