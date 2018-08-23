package p02_staticMembers;

public class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;
    private static double rate = DEFAULT_INTEREST;
    private static int bankAccountCount;

    private int id;
    private double balance;

    public BankAccount() {
        this.id = ++bankAccountCount;
    }

    public static void setInterestRate(double interest){
        rate =interest;
    }

    public double getInterest(int years){
        return this.balance* rate *years;
    }

    public int getId() {
        return id;
    }


    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if (amount>0) {
            this.balance += amount;
        }
    }

    @Override
    public String toString(){
        return "ID"+this.id;
    }
}