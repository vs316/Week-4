package junit_tests;

public class BankAccount {
    private double balance;
    private double amount;

    BankAccount(double balance, double amount) {
        this.balance = balance;
        this.amount = amount;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getAmount() {
        return amount;
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public boolean withdraw(double amount){
        if(amount>0){
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
        return false;
    }
}
