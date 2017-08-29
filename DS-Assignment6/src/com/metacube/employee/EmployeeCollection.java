package com.metacube.employee;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class EmployeeCollection {
    Set<Employee> employeeSet = new HashSet<Employee>();
    
    public boolean add(Employee employee){
        if(employeeSet.add(employee)){
            return true;
        }
        return false;
    }
    
    static class NameComparator implements Comparator<Object>{

        @Override
        public int compare(Object arg0, Object arg1) {
            Employee employee1 = (Employee)arg0;
            Employee employee2 = (Employee)arg1;
            return employee1.getName().compareTo(employee2.getName());
        }
        
    }
    
    public Set<Employee> getCollection() {
        return employeeSet;
    }
}
