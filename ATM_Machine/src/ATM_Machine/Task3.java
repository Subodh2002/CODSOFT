package ATM_Machine;

public class Task3 {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Create an ATM instance and connect it to the user's account
        ATM atm = new ATM(userAccount);

        // Display the ATM menu
        atm.displayMenu();
    }
}
