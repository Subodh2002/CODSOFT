package ATM_Machine;

import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: Rs.");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: Rs.");
                    double withdrawalAmount = scanner.nextDouble();
                    withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Your account balance: Rs." + userAccount.getBalance());
    }

    private void deposit(double amount) {
        if (amount > 0) {
            userAccount.deposit(amount);
            System.out.println("Deposit successful. Your new balance: Rs." + userAccount.getBalance());
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    private void withdraw(double amount) {
        if (amount > 0 && userAccount.getBalance() >= amount) {
            userAccount.withdraw(amount);
            System.out.println("Withdrawal successful. Your new balance: Rs." + userAccount.getBalance());
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        } else {
            System.out.println("Insufficient funds. Unable to complete the withdrawal.");
        }
    }
}
