package com.metacube.employee;

public class Employee implements Comparable<Employee>{
    private String empId;
    private String name;
    private String address;
    
    public Employee(String empId, String name) {
        this.empId = empId;
        this.name = name;
        this.address = "---";
    }
    public Employee(String empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }
    public String getEmpId() {
        return empId;
    }
    public void setEmpId(String empId) {
        this.empId = empId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public int compareTo(Employee employee) {
        return empId.compareTo(employee.empId);
    }
    @Override
    public int hashCode(){
        return empId.hashCode();
    }
    @Override
    public boolean equals(Object obj){
        return empId.equals(((Employee)obj).getEmpId());
    }
    @Override
    public String toString() {
        return "\nEmployee [Id: "+empId+", Name: "+name+", Address: "+address+"]";
    }
}
