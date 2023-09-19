package supportbank;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class CvsReader {
    String Path = "/home/aude/Desktop/BootCamp/SupportBank-Java/Transactions2014.csv";
    public ArrayList<ArrayList<String>> readRecords() throws Exception {
        ArrayList<ArrayList<String>> recordsTransactions = new ArrayList<ArrayList<String>>();
        String fileLine;
        String splitBy = ",";
        int counterNbTransaction = 0;
        try (Scanner scanner = new Scanner(new File(Path))) {
            scanner.useDelimiter(";");
            String[] headerFile = scanner.nextLine().split(splitBy);
            while (scanner.hasNext()) {
                fileLine = scanner.nextLine();
                String[] singleTransaction = fileLine.split(splitBy);
                recordsTransactions.add(new ArrayList<String>()); // create a new row for each line in the file
                //System.out.println(singleTransaction[1]);
                for (int i = 0; i < singleTransaction.length; i++) {
                    recordsTransactions.get(counterNbTransaction).add(i,singleTransaction[i]);
                }
                counterNbTransaction++;
                //System.out.println("la")
            }
        }
        return  recordsTransactions;
    }

}
