package supportbank;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class View {
    public static void displayAll(){
        // display name and amount
    }
    public static void displayAccountTransactions(HashMap<String, ArrayList<ArrayList<String>>> accounts,
                                                  String accountName){
        ArrayList<ArrayList<String>>allTransactions = new ArrayList<ArrayList<String>>();
        allTransactions = accounts.get(accountName);
        for (ArrayList<String> allTransaction : allTransactions) {
            System.out.println(allTransaction);
        }

    }

    public static void manageUserInput(){
        String listAllCommand = "List All";
        String listAccountCommand = "List";
        System.out.println("Choose an command:");
        System.out.println("List All");
        System.out.println("List [Account]");
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.next();
        if (operation.equals(listAllCommand)) {
            displayAll();
        } else {
            //displayAccountTransactions(accounts, accountName);
        }

    }
}
