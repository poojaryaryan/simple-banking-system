import java.util.ArrayList;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 1000;
        ArrayList<String> history = new ArrayList<>();

        while (true) {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();

                    if (deposit > 0) {
                        balance += deposit;
                        history.add("Deposited ₹" + deposit);
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();

                    if (withdraw <= 0) {
                        System.out.println("Invalid amount.");
                    } else if (withdraw > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        balance -= withdraw;
                        history.add("Withdrawn ₹" + withdraw);
                        System.out.println("Withdrawal successful.");
                    }
                    break;

                case 4:
                    if (history.isEmpty()) {
                        System.out.println("No transactions found.");
                    } else {
                        System.out.println("\nTransaction History:");
                        for (String transaction : history) {
                            System.out.println(transaction);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using our bank!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
