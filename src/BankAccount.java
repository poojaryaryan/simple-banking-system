public class BankAccount {
    private String name;
    private int pin;
    private double balance;
    private int accountNumber;

    public BankAccount( int accountNumber, String name, int pin, double balance){
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getName(){
        return name;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance+=amount;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public boolean withdraw(double amount){
        if(amount>balance){
            return false;
        }
        else{
            balance-=amount;
            return true;
        }
    }

    public boolean verifyPin(int enteredPin){
        return pin==enteredPin;
    }
}
