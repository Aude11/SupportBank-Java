package supportbank;
// Import the HashMap class
import java.util.HashMap;

import java.util.ArrayList;

public class Controler {
    //private ArrayList<ArrayList<String>> recordsTransactions;
    public double calculateBalance(HashMap<String, ArrayList<ArrayList<String>>> model){ //refactor this
        for (String name : model.keySet()) {
            ArrayList<ArrayList<String>> allTransactions = new ArrayList<ArrayList<String>>();
            allTransactions = model.get(name);
            int colPositionNameFrom = 1;
            int colPositionNameTo = 2;
            int colPositionAmount = 4;
            double balance = 0.0;
            for (int i = 0; i < allTransactions .size(); i++){
                String nameOfAccountFrom = allTransactions.get(i).get(colPositionNameFrom);
                String nameOfAccountTo = allTransactions.get(i).get(colPositionNameTo);
                double amountTransferred = Double.parseDouble(allTransactions .get(i).get(colPositionAmount));
                if (nameOfAccountFrom.equals(name)) {
                    // subtract money
                    balance = balance - amountTransferred;
                } else if (nameOfAccountTo.equals(name)) {
                    // add money to account
                    balance += amountTransferred;
                } else {
                    System.out.println("Something went wrong: transaction name issue");
                }
            }

            System.out.println("Name: " + name + " Balance: " + balance);
        }
        return 0.0;
    }

    public static void updateIncomingMoney (HashMap<String, Double> account,
                                            String nameOfAccount,
                                            double amount) {
        if (account.containsKey(nameOfAccount)) { 
            double newAmount = account.get(nameOfAccount) + amount;
            account.put(nameOfAccount, newAmount);
        } else {
            account.put(nameOfAccount,amount); 
        }
    }

    public static void updateOutgoingMoney (HashMap<String, Double> account,
                                            String nameOfAccount,
                                            double amount) {
        double newAmount;
        if (account.containsKey(nameOfAccount)) {
                newAmount = account.get(nameOfAccount) - amount;
            } else {
                newAmount = - amount;

            }
            account.put(nameOfAccount,newAmount);

    }
}
