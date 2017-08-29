package com.metacube.employee;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.metacube.employee.EmployeeCollection.NameComparator;

public class TestEmployeeCollection {
    EmployeeCollection employees = new EmployeeCollection();
    
    Employee employee1 = new Employee("E17/111", "Preeti");
    Employee employee2 = new Employee("E13/321", "Aman");
    Employee employee3 = new Employee("E15/321", "Ramesh");
    
    @Before
    public void initialize(){
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }
    
    @Test
    public void testAdd(){
        assertTrue("Error: Can't add employee with duplicate Id", employees.add(new Employee("E21/111", "Preksha")));
    }
    
    @Test
    public void testDuplicateAdd(){
        assertFalse("Error: Can't add employee with duplicate Id", employees.add(new Employee("E17/111", "Preksha")));
    }
    
    @Test
    public void testNaturalSort(){
        List<Employee> employeeList = new ArrayList<Employee>(employees.getCollection());
        Collections.sort(employeeList);
        
        List<Employee> expectedList = new ArrayList<Employee>();
        expectedList.add(employee2);
        expectedList.add(employee3);
        expectedList.add(employee1);
        assertEquals("Error: Unable to sort as expected",expectedList, employeeList);
    }

    @Test
    public void testNameSort(){
        List<Employee> employeeList = new ArrayList<Employee>(employees.getCollection());
        Collections.sort(employeeList,  new NameComparator());
        
        List<Employee> expectedList = new ArrayList<Employee>();
        expectedList.add(employee2);
        expectedList.add(employee1);
        expectedList.add(employee3);
        assertEquals("Error: Unable to sort as expected",expectedList, employeeList);
    }
}
