package options.connections;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import controller.SocialNetwork;
import entity.Entity;
import graph.Connections;
import graph.Nodes;
import menu.Action;

public class ConnectionRemoveAction implements Action{
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public boolean performAction() {
        Connections conn = SocialNetwork.getGraph().getConnections();
        String choice = "";
        if(SocialNetwork.getAllUserAccounts().containsKey(SocialNetwork.getLoginUserId())){
            choice = this.displayAllAccountsForConnections(SocialNetwork.getAllUserAccounts());
        }
        else if(SocialNetwork.getAllOrgAccounts().containsKey(SocialNetwork.getLoginUserId())){
            choice = this.displayAllAccountsForConnections(SocialNetwork.getAllOrgAccounts());
        }
        
        if(conn.getConnection().containsKey(SocialNetwork.getLoginUserId())){
            if("".equals(choice)){
                conn.getConnection().remove(SocialNetwork.getLoginUserId());
            }
            else{
                conn.getConnection().get(SocialNetwork.getLoginUserId()).removeNodes(choice);
            }
        }
        return false;
    }
    
    public String displayAllAccountsForConnections(Map<String, Entity> accounts){
        int choice;
        String key = "";
        int count = 1;
        try{
            Nodes node = SocialNetwork.getGraph().getConnections().getConnection().get(SocialNetwork.getLoginUserId());
            if(!node.getNodes().isEmpty()){
                for (Iterator<Entry<String, Entity>> iterator = accounts.entrySet().iterator(); iterator.hasNext();) {
                    Map.Entry<String, Entity> pair = (Map.Entry<String, Entity>) iterator.next();
                    
                    if(node.getNodes().contains(pair.getKey())){
                        System.out.println(count++ + ". "+pair.getKey());
                    }
                }
                System.out.println("Enter Choice to remove a connection with: ");
                choice = scanner.nextInt();
                if(choice >= count){
                    System.out.println("Enter a valid choice: ");
                    displayAllAccountsForConnections(accounts);
                }
                else{
                    count = 1;
                    for (Iterator<Entry<String, Entity>> iterator = accounts.entrySet().iterator(); iterator.hasNext();) {
                        Map.Entry<String, Entity> pair = (Map.Entry<String, Entity>) iterator.next();
                        if(node.getNodes().contains(pair.getKey())){
                            if(choice == count){
                                key = pair.getKey();
                                break;
                            }
                            
                            count++;
                            
                        }
                    }
                }
                
            }
            else {
                System.out.println("No Connections are available");
                
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return key;
    }
}
