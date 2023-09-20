package supportbank;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class View {
   private Controler controler;
   private HashMap<String, ArrayList<ArrayList<String>>> model;

    public View(Controler controler, HashMap<String, ArrayList<ArrayList<String>>> model) {
        this.controler = controler;
        this.model= model;
    }

    public void displayAll(){
        // display name and amount
        double a = controler.calculateBalance(model);
    }
    public void displayAccountTransactions(String accountName){
        ArrayList<ArrayList<String>>allTransactions = new ArrayList<ArrayList<String>>();
        allTransactions = model.get(accountName);
        for (ArrayList<String> allTransaction : allTransactions) {
            System.out.println(allTransaction);
        }

    }

    public static void checkUserInput(String operation) {
        //
    }

    public static void manageUserInput(){
        String listAllCommand = "List All";
        String listAccountCommand = "List";
        System.out.println("Choose an command:");
        System.out.println("List All");
        System.out.println("List [Account]");
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.next();
        checkUserInput(operation);
    }
}
