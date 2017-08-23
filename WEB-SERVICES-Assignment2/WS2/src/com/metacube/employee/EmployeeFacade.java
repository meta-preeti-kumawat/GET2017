package com.metacube.employee;

import java.io.IOException;
import java.util.Map;

public class EmployeeFacade {
    
    private static EmployeeFacade employeeFacade = null;
    private EmployeeFacade() {
        
    }
    
    /**
     * This is used to create class singleton and get available instance
     * @return InMemoryEmployeeDao
     * @throws IOException
     */
    synchronized public static EmployeeFacade getInstance() throws IOException{
        if(employeeFacade == null){            
            employeeFacade = new EmployeeFacade();
        }
        return employeeFacade;
    }
    
    /**
     * override clone method of object class (for the purpose of creating singleton class)
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    /**
     * Create employee
     * @param empName
     * @return employee
     * @throws IOException
     */
    public Employee createEmployee(String empName) throws IOException {
        Employee employee = new Employee();
        employee.setName(empName);
        employee = EmployeeDao.getInstance().create(employee);
        return employee;
    }

    /**
     * Fetch all employees
     * @return Map of employees
     * @throws IOException
     */
    public Map<String, Employee> getAllEmployees() throws IOException {
        return EmployeeDao.getInstance().getAll();
    }

    /**
     * Fetch specific employee using id
     * @param empId
     * @return employee
     * @throws IOException
     */
    public Employee getEmployeeById(String empId) throws IOException {
        return EmployeeDao.getInstance().getEmployeeById(empId);
    }

    /**
     * fetch specific employee list using name
     * @param empName
     * @return Map of employees with required name
     * @throws IOException
     */
    public Map<String, Employee> getEmployeeByName(String empName) throws IOException {
        return EmployeeDao.getInstance().getEmployeeByName(empName);
    }

    /**
     * Removes employee by Id
     * @param empId
     * @return message
     * @throws IOException
     */
    public String removeEmployeeById(String empId) throws IOException {
        Employee employee = new Employee();
        employee.setId(empId);
        String output = "";
        if(getAllEmployees().containsKey(empId)){
            EmployeeDao.getInstance().remove(employee);    
            output = "Employee is removed Successfully";
        }
        else{
            output = "No such user available with given Id";
        }
        return output;
    }
    
}
