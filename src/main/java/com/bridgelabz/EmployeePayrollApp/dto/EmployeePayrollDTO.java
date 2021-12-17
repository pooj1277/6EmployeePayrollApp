package com.bridgelabz.EmployeePayrollApp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.*;

public class EmployeePayrollDTO {
    public String name;
    public long salary;
    public int employeeId;
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
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}