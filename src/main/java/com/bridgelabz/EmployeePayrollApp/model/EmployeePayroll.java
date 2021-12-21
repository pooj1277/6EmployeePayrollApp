package com.bridgelabz.EmployeePayrollApp.model;


public class EmployeePayroll {
    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayroll() {}

    public EmployeePayroll(int empId, String name,long salary) {
        this.employeeId = empId;
        this.name= name;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }
    
    public String toString() {
        return "Emp ID=" + employeeId + "Name=" + name + " Salary=" + salary;
    }
}
