package supportbank;
// Import the HashMap class
import java.util.HashMap;

import java.util.ArrayList;

public class Account{
    public HashMap<String, ArrayList<ArrayList<String>>> create(CvsReader cvsBankReader) {
        //CvsReader cvsBankReader = new CvsReader();// put in argument
        int colPositionNameFrom = 1;
        int colPositionNameTo = 2;
        ArrayList<ArrayList<String>> recordTransactions = new ArrayList<ArrayList<String>>();
        HashMap<String, ArrayList<ArrayList<String>>> account = new HashMap<String, ArrayList<ArrayList<String>>>();
        try {
            recordTransactions = cvsBankReader.readRecords();
            for (int i = 0; i < recordTransactions.size(); i++){
                String nameOfAccountFrom = recordTransactions.get(i).get(colPositionNameFrom);
                String nameOfAccountTo = recordTransactions.get(i).get(colPositionNameTo);
                updateAccountListOfTransaction(account, nameOfAccountFrom, recordTransactions, i);
                updateAccountListOfTransaction(account, nameOfAccountTo, recordTransactions, i);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //System.out.println(account.get("Sarah T"));
        return account;
    }
    public static void updateAccountListOfTransaction(HashMap<String, ArrayList<ArrayList<String>>> account,
                                                      String nameOfAccount,
                                                      ArrayList<ArrayList<String>> transactions,
                                                      int numbOfLineToAdd){
        ArrayList<ArrayList<String>> value;
        if (account.containsKey(nameOfAccount)) {
            value = account.get(nameOfAccount);
        } else {
            value = new ArrayList<ArrayList<String>>();
        }
        value.add(transactions.get(numbOfLineToAdd));
        account.put(nameOfAccount, value);
    }

}
