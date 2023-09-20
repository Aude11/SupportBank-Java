package supportbank;
// Import the HashMap class
import java.util.HashMap;

import java.util.ArrayList;

public class Controler {
    //private ArrayList<ArrayList<String>> recordsTransactions;
    public void calculateBalance() {
        CvsReader cvsBankReader = new CvsReader();
        int colPositionNameFrom = 1;
        int colPositionNameTo = 2;
        int colPositionAmount = 4;
        ArrayList<ArrayList<String>> recordTransactions = new ArrayList<ArrayList<String>>();
        // Create a HashMap object that store all the account
        HashMap<String, Double> account = new HashMap<String, Double>();
        try {
            recordTransactions = cvsBankReader.readRecords();
            for (int i = 0; i < recordTransactions.size(); i++){
                String nameOfAccountFrom = recordTransactions.get(i).get(colPositionNameFrom);
                String nameOfAccountTo = recordTransactions.get(i).get(colPositionNameTo);
                double amountTransferred = Double.parseDouble(recordTransactions.get(i).get(colPositionAmount));
                updateIncomingMoney(account, nameOfAccountTo, amountTransferred);
                updateOutgoingMoney(account, nameOfAccountFrom, amountTransferred);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(account.get("Sarah T"));
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
            if (account.containsKey(nameOfAccount)) { 
                double newAmount = account.get(nameOfAccount) - amount;
                account.put(nameOfAccount, newAmount);
            } else {
                double newAmount = - amount;
                account.put(nameOfAccount,newAmount); 
            }
    
    }
}
