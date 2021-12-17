package com.bridgelabz.EmployeePayrollApp.service;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.EmployeePayrollApp.controller.EmployeePayrollController;
import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.exception.EmployeePayrollException;
import com.bridgelabz.EmployeePayrollApp.model.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeePayrollRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	
	Logger logger = LoggerFactory.getLogger(EmployeePayrollService.class);
	@Autowired
	private EmployeePayrollRepository employeeRepository;
	private List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeePayrollList;
	}
	
	@Override
	public EmployeePayrollData addPerson(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData emp = new EmployeePayrollData();
		emp.setEmployeeId(employeePayrollDTO.getEmployeeId());
		emp.setName(employeePayrollDTO.getName());
		emp.setSalary(employeePayrollDTO.getSalary());
		return employeeRepository.save(emp);
				
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		return employeePayrollList.stream().filter(empData -> empData.getEmployeeId() == empId).findFirst()
				.orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData = null;
		payrollData = new EmployeePayrollData(employeePayrollDTO);
		logger.debug("Emp Data: " + payrollData.toString());
		employeePayrollList.add(payrollData);
		return employeeRepository.save(payrollData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData payrollData = this.getEmployeePayrollDataById(empId);
		payrollData.updateEmployeePayrollData(employeePayrollDTO);
		return employeeRepository.save(payrollData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		EmployeePayrollData payrollData = this.getEmployeePayrollDataById(empId);
		employeeRepository.delete(payrollData);

	}
//	@Override
//	public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
//		return employeeRepository.findEmployeesById(department);
//	}

}