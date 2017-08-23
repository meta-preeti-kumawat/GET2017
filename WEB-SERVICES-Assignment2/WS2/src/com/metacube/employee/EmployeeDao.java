package com.metacube.employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


public class EmployeeDao {
    private static String filePath = "wtpwebapps\\WS2\\StoreFile\\Employee.json";
    private static EmployeeDao employeeDao = null;
    private static BufferedReader readDataLine;
    private static Map<String, Employee> dataList;
    private static Writer writer;
    private static Gson gson = new Gson();
    
    private static File file;
    
    private EmployeeDao() throws IOException{
        // Create file if not available
        File catalinaBase = new File( System.getProperty( "catalina.base" ) ).getAbsoluteFile();
        file = new File(catalinaBase,filePath );
        if(!file.exists()) {
               file.createNewFile();
        }
        dataList = new HashMap<String, Employee>();
        dataList = getAll();
    }
    
    /**
     * This is used to create class singleton and get available instance
     * @return InMemoryEmployeeDao
     * @throws IOException
     */
    synchronized public static EmployeeDao getInstance() throws IOException{
        if(employeeDao == null){            
            employeeDao = new EmployeeDao();
        }
        return employeeDao;
    }
    
    /**
     * override clone method of object class (for the purpose of creating singleton class)
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
    /**
     * getAll() method will return a map containing all employees from file
     * @throws IOException 
     */
    public Map<String, Employee> getAll() throws IOException{
        readDataLine = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        Type type = new TypeToken<Map<String, Employee>>(){}.getType();
        Map<String, Employee> empMap = gson.fromJson(readDataLine, type);
        if (empMap!=null) {
            dataList.putAll(empMap);
        }
        readDataLine.close();
        return dataList;
    }

    /**
     * create a new employee
     * @throws IOException 
     */
    public Employee create(Employee employee) throws IOException {
        writer = new FileWriter(file.toString());
        Gson gson = new GsonBuilder().create();
        String id = generateId();
        employee.setId(id);
        dataList.put(id, employee);
        gson.toJson(dataList, writer);
        writer.close();
        return employee;
    }
    
    /**
     * get employee object by Id
     */
    public Employee getEmployeeById(String id) {
        Employee employee = new Employee();
        if (dataList.containsKey(id)) {
            employee = dataList.get(id);
        }
        return employee;
    }

    /**
     * remove a employee from map
     * @throws IOException 
     */
    public void remove(Employee entity) throws IOException{
        writer = new FileWriter(file.toString());
        Gson gson = new GsonBuilder().create();
        dataList.remove(entity.getId()); 
        gson.toJson(dataList, writer);
        writer.close();
    }
    
    /**
     * generates a random id for each employee
     * @return string
     */
    public String generateId() {
        int id = (int) (Math.random()*10000);
        String idStr = Integer.toString(id);
        if(dataList != null && dataList.get(idStr) != null){
            idStr = generateId();
        }
        return idStr;
    }

    public Map<String, Employee> getEmployeeByName(String empName) {
        Map<String, Employee> employeeByName = new HashMap<String, Employee>();
        for (Map.Entry<String, Employee> item : dataList.entrySet()) {
            if(item.getValue().getName().equalsIgnoreCase(empName)){
                Employee employee = new Employee();
                employee = item.getValue();
                employeeByName.put(employee.getId(), employee);
            }
        }
        return employeeByName;
    }
}
