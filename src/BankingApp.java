import java.util.ArrayList;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 1000;
        int pin = 1234;
        int depositCounter = 0;
        int withdrawCounter = 0;
        int attempts = 3;
        ArrayList<String> history = new ArrayList<>();
        history.add("Account opened with ₹1000");

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        while(attempts>0){
            System.out.print("Enter 4 digit pin: ");
            int enteredPin = sc.nextInt();

            if(enteredPin==pin){
                System.out.println("Login successful!");
                break;
            }
            else{
                attempts--;
                System.out.println("Incorrect pin! Attempts left: " + attempts);
            }
        }
        if(attempts==0){
            System.out.println("Account locked.");
            sc.close();
            return;
        }

        System.out.println("Welcome, " + name + "!");

        while (true) {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Mini Statement");
            System.out.println("6. Exit");
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
                        System.out.println("Current Balance: ₹" + balance);
                        depositCounter++;
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
                        System.out.println("Current Balance: ₹" + balance);
                        withdrawCounter++;
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
                    System.out.println("Account holder: " + name);
                    System.out.println("Balance: " + balance);
                    System.out.println("Total deposits: " + depositCounter);
                    System.out.println("Total withdrawals: " + withdrawCounter);
                    if(history.isEmpty()) System.out.println("Last transaction: None");
                    else System.out.println("Last transaction: " + history.get(history.size()-1));
                    break;

                case 6:
                    System.out.println("Thank you for using our bank!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
