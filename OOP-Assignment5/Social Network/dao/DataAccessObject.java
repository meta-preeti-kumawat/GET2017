package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 
 * @author Preeti Kumawat
 * Date: 27-07-2017
 * Class Name: DataAccessObject
 *
 */
public class DataAccessObject {
    private FileInputStream dataFile;
    private BufferedReader readDataLine;
    private String inputText = new String();
    private ArrayList<String> dataList;
    private int count = 0;
    
    public ArrayList<String> accessFileForRead(String path) throws IOException {
        dataFile = new FileInputStream(path);
        readDataLine = new BufferedReader(new InputStreamReader(dataFile));
        inputText = readDataLine.readLine();    
        dataList = new ArrayList<String>();
       
        while(inputText != null){
            if(inputText != ""){
                dataList.add(inputText); 
            }
           inputText = readDataLine.readLine();  
        }
        dataFile.close();
        return dataList;
    }
    public void accessFileToWrite(String string, String filePath) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath), true));
        if(count != 0){
            writer.newLine();
        }
        count++;
        writer.write(string);
        writer.close();
    }
    
    public void clearFile(String filePath) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)));
        writer.write("");
        count = 0;
        writer.close();
    }
    public void replaceInFile(String string, String filePath) throws IOException{
        dataFile = new FileInputStream(filePath);
        readDataLine = new BufferedReader(new InputStreamReader(dataFile));
        inputText = readDataLine.readLine();    
        while(inputText != null){
            inputText.replaceAll("^"+string+",.*", "");
            inputText = readDataLine.readLine();
        }
        
    }
}
