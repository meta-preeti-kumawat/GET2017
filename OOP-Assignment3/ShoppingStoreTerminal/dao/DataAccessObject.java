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
 * Date: 24-07-2017
 * Class Name: DataAccessObject
 *
 */
public class DataAccessObject {
    private FileInputStream dataFile;
    private BufferedReader readDataLine;
    private String inputText = new String();
    private ArrayList<String> dataList;
    private static String error;
    
    /**
     * this method provide file access to read
     * @param path
     * @return ArrayList<String>
     * @throws IOException
     */
    public ArrayList<String> accessFileForRead(String path) throws IOException {
        dataFile = new FileInputStream(path);
        readDataLine = new BufferedReader(new InputStreamReader(dataFile));
        inputText = readDataLine.readLine();    
        dataList = new ArrayList<String>();
       
        while(inputText != null){
           dataList.add(inputText); 
           inputText = readDataLine.readLine();  
        }
        dataFile.close();
        return dataList;
    }
    
    /**
     * this method provides file access to write
     * @param string
     * @param filePath
     */
    public static void accessFileToWrite(String string, String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)));
            writer.write(string);
            writer.close();
        } catch (IOException ie) {
            error = "Error: File not found";
        }
    }
    
    public static String getError(){
        return error;
    }
}
