package options.connections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import controller.SocialNetwork;
import entity.Entity;
import graph.Connections;
import graph.Nodes;
import menu.Action;

public class ConnectionAddAction implements Action{
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
            conn.getConnection().get(SocialNetwork.getLoginUserId()).setNodes(choice);
        }
        else{
            Nodes node = new Nodes();
            node.setNodes(choice);
            conn.putNewConnection(SocialNetwork.getLoginUserId(), node);
        }
        return false;
    }
    
    public String displayAllAccountsForConnections(Map<String, Entity> accounts){
        int choice;
        String key = "";
        int count = 1;
        try{
            if(!accounts.isEmpty()){
                for (Iterator<Entry<String, Entity>> iterator = accounts.entrySet().iterator(); iterator.hasNext();) {
                    Map.Entry<String, Entity> pair = (Map.Entry<String, Entity>) iterator.next();
                    if(!pair.getKey().equals(SocialNetwork.getLoginUserId())){
                        System.out.println(count++ + ". "+pair.getKey());
                    }
                }
                if(count != 1){
                    System.out.println("Enter Choice to create a connection with: ");
                    choice = scanner.nextInt();
                    count = 1;
                    for (Iterator<Entry<String, Entity>> iterator = accounts.entrySet().iterator(); iterator.hasNext();) {
                        Map.Entry<String, Entity> pair = (Map.Entry<String, Entity>) iterator.next();
                        if( !pair.getKey().equals(SocialNetwork.getLoginUserId())){
                            if(choice == count){
                                key = pair.getKey();
                                break;
                            }
                            count++;    
                        }
                    }
                
                }
                else{
                    System.out.println("No users to connect with");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
        return key;
    }
}
