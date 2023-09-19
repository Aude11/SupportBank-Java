package supportbank;
// Import the HashMap class
import java.util.HashMap;

import java.util.ArrayList;

public class Controler {
    //private ArrayList<ArrayList<String>> recordsTransactions;
    public void createAccount() {
        CvsReader cvsBankReader = new CvsReader();
        int colPositionName = 1;
        int colPositionAmount = 4;
        ArrayList<ArrayList<String>> recordTransactions = new ArrayList<ArrayList<String>>();
        // Create a HashMap object that store all the account
        HashMap<String, Double> account = new HashMap<String, Double>();
        try {
            recordTransactions = cvsBankReader.readRecords();
            for (int i = 0; i < recordTransactions.size(); i++){
                String nameOfAccountFrom = recordTransactions.get(i).get(1);
                String nameOfAccountTo = recordTransactions.get(i).get(2);
                //String a = recordTransactions.get(i).get()
                double amountTransferred = Double.parseDouble(recordTransactions.get(i).get(4));
                if (account.containsKey(nameOfAccountFrom)) { // this should be a method
                    double amountInitial = account.get(nameOfAccountFrom);
                    double newAmount = amountInitial - amountTransferred;
                    account.put(nameOfAccountFrom, newAmount);
                } else {
                    double amountDeducted = - amountTransferred;
                    account.put(nameOfAccountFrom,amountDeducted); // carefull
                }
                if (account.containsKey(nameOfAccountTo)) { // this should be a method
                    double amountInitial = account.get(nameOfAccountTo);
                    double newAmount = amountInitial + amountTransferred;
                    account.put(nameOfAccountTo, newAmount);
                } else {
                    account.put(nameOfAccountFrom,amountTransferred);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(account);
        //account.put()


    }
}
