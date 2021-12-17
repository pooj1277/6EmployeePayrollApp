package com.bridgelabz.EmployeePayrollApp.service;

import java.util.List;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	List<EmployeePayrollData> getEmployeePayrollData();
	EmployeePayrollData getEmployeePayrollDataById(int empId);
	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);
	EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO);
	void deleteEmployeePayrollData(int empId);
	EmployeePayrollData addPerson(EmployeePayrollDTO employeePayrollDTO);
}