import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int depositCounter = 0;
        int withdrawCounter = 0;
        int attempts = 3;

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        BankAccount account = new BankAccount(name,1234,1000);

        TransactionManager transactions = new TransactionManager();
        if(account.getBalance()>0){
            transactions.addTransaction("Account opened with ₹" + account.getBalance());
        }

        while(attempts>0){
            System.out.print("Enter 4 digit pin: ");
            int enteredPin = sc.nextInt();

            if(account.verifyPin(enteredPin)){
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

        System.out.println("Welcome, " + account.getName() + "!");

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
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double deposit = sc.nextDouble();

                    while(!(deposit>0)){
                        System.out.print("Enter valid amount to deposit: ₹");
                        deposit = sc.nextDouble();
                    }
                    if(deposit>0){
                        account.deposit(deposit);
                        transactions.addTransaction("Deposited: ₹" + deposit);
                        System.out.println("Deposit successful.");
                        System.out.println("Current Balance: ₹" + account.getBalance());
                        depositCounter++;
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdraw = sc.nextDouble();

                    while(!(withdraw>0)){
                        System.out.print("Enter valid amount to withdraw: ₹");
                        withdraw = sc.nextDouble();
                    }

                    if (account.withdraw(withdraw)) {
                        account.withdraw(withdraw);
                        transactions.addTransaction("Withdrawn: ₹" + withdraw);
                        System.out.println("Withdrawal successful.");
                        System.out.println("Current Balance: ₹" + account.getBalance());
                        withdrawCounter++;
                    }
                    else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 4:
                    transactions.showHistory();
                    break;

                case 5:
                    System.out.println("Account holder: " + account.getName());
                    System.out.println("Balance: " + account.getBalance());
                    System.out.println("Total deposits: " + depositCounter);
                    System.out.println("Total withdrawals: " + withdrawCounter);
                    System.out.println(transactions.getLastTransaction());
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
