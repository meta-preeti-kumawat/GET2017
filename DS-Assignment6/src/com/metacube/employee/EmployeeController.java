package com.metacube.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metacube.employee.EmployeeCollection.NameComparator;

public class EmployeeController {
    public static void main(String[] args) {
        EmployeeCollection employees = new EmployeeCollection();
        
        employees.add(new Employee("E11/111", "Preeti"));
        employees.add(new Employee("E13/321", "Priya"));
        employees.add(new Employee("E09/131", "Abhishek", "Street 11"));
        employees.add(new Employee("E12/151", "Sumit", "Jaipur"));
        employees.add(new Employee("E10/641", "Aman"));
        employees.add(new Employee("E10/641", "Ajay"));
        
        System.out.println("Before Sorting:"+employees.getCollection());
        
        List<Employee> employeeList = new ArrayList<Employee>(employees.getCollection());
        Collections.sort(employeeList);
        System.out.println("\nAfter Natural Sorting:"+employeeList);
        
        employeeList = new ArrayList<Employee>(employees.getCollection());
        Collections.sort(employeeList, new NameComparator());
        System.out.println("\nAfter Name Sorting:"+employeeList);
    }
}
