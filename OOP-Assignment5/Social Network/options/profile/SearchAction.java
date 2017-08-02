package options.profile;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import controller.SocialNetwork;
import entity.Entity;
import menu.Action;

public class SearchAction implements Action{
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public boolean performAction() {
        try{
            System.out.print("Enter a name to be searched: ");
            String searchName = scanner.nextLine();
            Map<String, Entity> accounts= SocialNetwork.getAllUserAccounts();
            accounts.putAll(SocialNetwork.getAllUserAccounts());
            for (Iterator<Entry<String, Entity>> iterator = accounts.entrySet().iterator(); iterator.hasNext();) {
                Map.Entry<String, Entity> pair = (Map.Entry<String, Entity>) iterator.next();
                if(pair.getValue().getName().equals(searchName)){
                    System.out.println("Name: "+searchName);
                    System.out.println("Status Line: "+pair.getValue().getStatus());
                }
            }
        }
        catch(Exception e){
            System.out.println("No Data Found :"+e.getMessage());
        }
        
        return false;
    }
}
