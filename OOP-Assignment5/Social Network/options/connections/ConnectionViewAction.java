package options.connections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import controller.SocialNetwork;
import entity.Entity;
import graph.Connections;
import graph.Nodes;
import menu.Action;

public class ConnectionViewAction implements Action{
    @Override
    public boolean performAction() {
        Connections conn = SocialNetwork.getGraph().getConnections();
        if(conn.getConnection().containsKey(SocialNetwork.getLoginUserId())){
            Nodes nodes = new Nodes();
            nodes = conn.getConnection().get(SocialNetwork.getLoginUserId());
            Set<String> listOfNodes = nodes.getNodes();
            int count = 1;
            Map<String, Entity> users = new HashMap<String, Entity>();
            users = SocialNetwork.getAllUserAccounts();
            Map<String, Entity> org = new HashMap<String, Entity>();
            org = SocialNetwork.getAllOrgAccounts();
            for (Iterator<String> iterator = listOfNodes.iterator(); iterator.hasNext();) {
                String string = (String) iterator.next();
                if(users.containsKey(string)){
                    System.out.println(count++ + ". User "+ string+": "+users.get(string).getName());
                }
                else if(org.containsKey(string)){
                    System.out.println(count++ + ". Organization "+ string+": "+org.get(string).getName());
                }
            }
            if (count == 1) {
                System.out.println("No Connections Available yet");
            }
        }
        else{
            System.out.println("No Connections Available yet");
        }
        return false;
    }
}
