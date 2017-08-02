package entity;

import java.io.IOException;

import dao.DataAccessObject;

public class EntityUtils {
    private DataAccessObject dao = new DataAccessObject();
    private String error = null;
    
    public String getError() {
        return error;
    }
    
    public boolean createAccount(String data, String filePath) {
        boolean check = false;
        try {
            dao.accessFileToWrite(data, filePath);
        } catch (IOException e) {
            this.error = "File not available";
            check  = false;
        }
        return check;    
    }
    
    public void removeFromFile(String data, String filePath){
        try {
            dao.replaceInFile(data, filePath);
        } catch (IOException e) {
            this.error = "File not available";
        }
    }
}
