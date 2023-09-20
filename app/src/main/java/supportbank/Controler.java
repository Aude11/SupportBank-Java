package supportbank;
// Import the HashMap class
import java.util.HashMap;

import java.util.ArrayList;

public class Controler {
    //private ArrayList<ArrayList<String>> recordsTransactions;
    public double calculateBalance(ArrayList<ArrayList<String>> allTransactions, String name,
                                   int colPositionNameFrom , int colPositionNameTo,
                                   int colPositionAmount) { //refactor this
        double balance = 0.0;
        for (int i = 0; i < allTransactions.size(); i++) {
            String nameOfAccountFrom = allTransactions.get(i).get(colPositionNameFrom);
            String nameOfAccountTo = allTransactions.get(i).get(colPositionNameTo);
            double amountTransferred = Double.parseDouble(allTransactions.get(i).get(colPositionAmount));
            if (nameOfAccountFrom.equals(name)) {
                // subtract money
                balance -= amountTransferred;
            } else if (nameOfAccountTo.equals(name)) {
                // add money to account
                balance += amountTransferred;
            } else {
                System.out.println("Something went wrong: transaction name issue");
            }
        }
        return balance;
    }
}
