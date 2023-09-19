package supportbank;

public class Account {
    private String name;
    private double balance = 0;
    public Account (String name){
        this.name = name;
    }
    public void display() {


    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double amount){
        balance += amount;
    }
}
