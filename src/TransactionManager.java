import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TransactionManager {
    private ArrayList<String> history = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
    String timestamp = LocalDateTime.now().format(formatter);

    public void addTransaction(String transaction){
        history.add(timestamp + "-" + transaction);
    }

    public void showHistory(){
        if(history.isEmpty()){
            System.out.println("No Transactions Found.");
            return;
        }
        System.out.println("\n---Transaction History---");
        for(String transaction : history){
            System.out.println(transaction);
        }
    }

    public String getLastTransaction(){
        if(history.isEmpty()){
            return "Last Transaction: None";
        }
        else{
            return "Last Transaction: " + history.get(history.size()-1);
        }
    }
}
