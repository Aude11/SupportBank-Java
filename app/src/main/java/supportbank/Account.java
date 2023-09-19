package supportbank;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class Account {
    private String name;
    private double balance = 0;
    private ArrayList<ArrayList<String>> transactionHistory;
    public Account (String name){
        this.name = name;
        //this.transactionHistory = transactions;
    }
    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<ArrayList<String>> getTransactionHistory() {
        return transactionHistory;
    }

    public void setBalance(double amount){
        balance += amount;
    }
}
