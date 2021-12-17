package com.bridgelabz.EmployeePayrollApp.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;

@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "name")
	private String name;
	@Column(name = "salary")
	private long salary;

//	@ElementCollection
//	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
//	@Column(name = "department")
//	private List<String> departments;

	public EmployeePayrollData() {

	}

	public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		this.updateEmployeePayrollData(employeePayrollDTO);
	}

	public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		this.name = employeePayrollDTO.name;
		this.employeeId = employeePayrollDTO.employeeId;
		this.salary = employeePayrollDTO.salary;
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