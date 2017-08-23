package com.metacube.employee;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Path("/employee")
public class EmployeService {
    private Gson gson = new Gson();
    
    /**
     * This create a new employee
     * @param empName
     * @return employee in json format
     */
    @GET
    @Path("/createEmployee/{empName}")
    @Produces(MediaType.APPLICATION_JSON)
    public String createEmployee(@PathParam("empName") String empName){
        String output = "";
        try {
            Employee employee = new Employee();
            employee = EmployeeFacade.getInstance().createEmployee(empName);
            output = gson.toJson(employee);
                    
        } catch (IOException e) {
             output = "Error";
        }
        return output;
    }
    
    /**
     * @return allEmployees in json
     */
    @GET
    @Path("/getAllEmployees")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEmployees(){
        String output = "";
        try {
            Map<String, Employee> employeeMap = new HashMap<String, Employee>();
            employeeMap = EmployeeFacade.getInstance().getAllEmployees();
            output = gson.toJson(employeeMap);
                    
        } catch (IOException e) {
             output = "Error";
             e.printStackTrace();
        }
        return output;
    }
    
    /**
     * Fetch employee details using Id
     * @param empId
     * @return employee
     */
    @GET
    @Path("/getEmployeeById/{empId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeById(@PathParam("empId") String empId){
        String output = "";
        try {
            Employee employee = new Employee();
            employee = EmployeeFacade.getInstance().getEmployeeById(empId);
            output = gson.toJson(employee);
                    
        } catch (IOException e) {
             output = "Error";
        }
        return output;
    }
    
    /**
     * Fetch employee details by name
     * @param empName
     * @return employee
     */
    @GET
    @Path("/getEmployeeByName/{empName}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeByName(@PathParam("empName") String empName){
        String output = "";
        try {
            Map<String, Employee> employeeMap = new HashMap<String, Employee>();
            employeeMap = EmployeeFacade.getInstance().getEmployeeByName(empName);
            output = gson.toJson(employeeMap);
                    
        } catch (IOException e) {
             output = "Error";
        }
        return output;
    }
    
    /**
     * Removes employee by Id
     * @param empId
     * @return message
     */
    @GET
    @Path("/removeEmployeeById/{empId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String removeEmployeeById(@PathParam("empId") String empId){
        String output = "";
        try {
            output = EmployeeFacade.getInstance().removeEmployeeById(empId);
        } catch (IOException e) {
             output = "Error";
        }
        return output;
    }
}
