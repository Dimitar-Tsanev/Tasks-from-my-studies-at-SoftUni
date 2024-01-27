package BankAccount;

public class BankAccount {
    private static final double DEFAULT_INTEREST = 0.02;
    private static double interestRate = DEFAULT_INTEREST;
    private static int bankAccountCount = 1;
    private int id;
    private double balance;

    public BankAccount (){
       this.id = bankAccountCount++;

    }
    public int getId(){
        return this.id;
    }

    public static void setInterest (double rate){
        BankAccount.interestRate = rate;

    }
    public void deposit (double amount){
        this.balance += amount;

    }
    public double getInterestRate (int year) {
        return BankAccount.interestRate * year * this.balance;

    }
}
