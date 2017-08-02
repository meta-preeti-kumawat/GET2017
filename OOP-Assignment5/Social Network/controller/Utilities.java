package controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import dao.DataAccessObject;
import entity.Entity;
import entity.Organization;
import entity.User;
import graph.Graph;
import graph.Nodes;

public class Utilities {
    private DataAccessObject dao = new DataAccessObject();
    private DataAccessObject dao_user = new DataAccessObject();
    private DataAccessObject dao_org = new DataAccessObject();
    private DataAccessObject dao_connection = new DataAccessObject();
    private String error = null;
    
    public String getError() {
        return error;
    }

    public static void checkAndCreateFile(ArrayList<String> listOfPaths) throws IOException {
        for (Iterator<String> iterator = listOfPaths.iterator(); iterator.hasNext();) {
            String filePathString = (String) iterator.next();
            File file = new File(filePathString);
            if(!file.exists()) { 
                file.createNewFile();
            }
        }
        
    }
    
    public Map<String, Entity> getAllData(String filePath, Entity entity){
        Map<String, Entity> accounts = new HashMap<String, Entity>();
        try {
            ArrayList<String> accountList = dao.accessFileForRead(filePath);
            for (Iterator<String> iterator_accounts = accountList.iterator(); iterator_accounts
                    .hasNext();) {
                String string = (String) iterator_accounts.next();
                entity = entity.splitData(string);
                accounts.put(entity.getId(), entity);
            }
        } catch (IOException e) {
            this.error = "File not available";
        }
        return accounts;
    }

    public Graph getAllConnections(String filePath) {
        Graph graph = new Graph();
        try{
            ArrayList<String> accountList = dao.accessFileForRead(filePath);
            for (Iterator<String> iterator_accounts = accountList.iterator(); iterator_accounts
                    .hasNext();) {
                
                String string = (String) iterator_accounts.next();
                
                graph = graph.splitData(string);
            }
        } 
        catch (IOException e) {
            this.error = "File not available";
        }
        return graph;
    }
    
    public void clearAllFiles(){
        try {
            dao_user.clearFile(SocialNetwork.getUserAccountFile());
            dao_org.clearFile(SocialNetwork.getOrgAccountFile());
            dao_connection.clearFile(SocialNetwork.getConnectionFile());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
    public void saveAllData(){
        String userData = "";
        this.clearAllFiles();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Map<String, Entity> user = SocialNetwork.getAllUserAccounts();
        try{
            for (Iterator<Entry<String, Entity>> iterator = user.entrySet().iterator(); iterator.hasNext();) {
                userData = "";
                Map.Entry<String, Entity> pair = (Map.Entry<String, Entity>) iterator.next();
                String date = df.format(((User)pair.getValue()).getDateOfBirth());
                userData += pair.getKey() + "," + pair.getValue().getName() 
                            + "," + date 
                            + "," + ((User)pair.getValue()).getGender() + "," 
                            + pair.getValue().getStatus(); 
                 try {
                    dao_user.accessFileToWrite(userData, SocialNetwork.getUserAccountFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e){
            System.out.println("Cannot save data: "+ e.getMessage());;
        }
        
        Map<String, Entity> org = SocialNetwork.getAllOrgAccounts();
        for (Iterator<Entry<String, Entity>> iterator = org.entrySet().iterator(); iterator.hasNext();) {
            userData = "";
            
            Map.Entry<String, Entity> pair = (Map.Entry<String, Entity>) iterator.next();
            userData += pair.getKey() + "," + pair.getValue().getName() 
                         + "," + ((Organization)pair.getValue()).getEstablishmentYear() 
                         + "," + pair.getValue().getStatus(); 
            try {
                dao_org.accessFileToWrite(userData, SocialNetwork.getOrgAccountFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
        Graph graph = SocialNetwork.getGraph();
        Map<String, Nodes> conn = graph.getConnections().getConnection();
        for (Iterator<Entry<String, Nodes>> iterator = conn.entrySet().iterator(); iterator.hasNext();) {
            userData = "";
            
            Map.Entry<String, Nodes> pair = (Map.Entry<String, Nodes>) iterator.next();
            userData += pair.getKey() +"-";
            Nodes node = pair.getValue();
            Set<String> listOfNodes = node.getNodes();
            int count = 1;
            for (Iterator<String> iterator2 = listOfNodes.iterator(); iterator2
                    .hasNext();) {
                String string = (String) iterator2.next();
                if(count == 1){
                    userData += string;
                    count++;
                }
                else{
                    userData += ","+string;
                }
            }
            try {
                dao_connection.accessFileToWrite(userData, SocialNetwork.getConnectionFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
     
    }

}
