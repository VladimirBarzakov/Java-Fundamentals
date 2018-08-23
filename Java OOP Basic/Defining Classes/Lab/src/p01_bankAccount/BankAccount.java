package p01_bankAccount;

public class BankAccount {
    private int id;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if (amount>0) {
            this.balance += amount;
        }
    }

    public void withdraw(double amount){
        if (amount>0) {
            this.balance -= amount;
        }
    }

    @Override
    public String toString(){
        return "ID"+this.id;
    }
}
