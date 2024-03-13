package task2;

import java.util.Scanner;

public class ATMInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123456", 1000);
        BankAccount account2 = new BankAccount("654321", 2000);

        System.out.println("Welcome to the ATM Interface!");

        while (true) {
            System.out.println("\n1. Check Balance\n2. Withdraw\n3. Deposit\n4. Transfer\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + account1.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account1.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account1.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's account number: ");
                    String recipientAccountNumber = scanner.next();
                    BankAccount recipient = recipientAccountNumber.equals(account2.getAccountNumber()) ? account2 : null;
                    if (recipient != null) {
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        account1.transfer(recipient, transferAmount);
                    } else {
                        System.out.println("Recipient account not found.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM Interface. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
