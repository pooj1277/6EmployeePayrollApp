package com.bridgelabz.EmployeePayrollApp.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.dto.ResponseDTO;
import com.bridgelabz.EmployeePayrollApp.exception.EmployeePayrollExceptionHandler;
import com.bridgelabz.EmployeePayrollApp.model.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollApp.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	Logger logger = LoggerFactory.getLogger(EmployeePayrollController.class);
	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@RequestMapping(value = { "", "/", "get" })
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		List<EmployeePayrollData> payrollData = null;
		payrollData = employeePayrollService.getEmployeePayrollData();
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success", payrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	// curl localhost:8888/employeepayrollservice/get/1 -w "\n"

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrollData payrollData = null;
		payrollData = employeePayrollService.getEmployeePayrollDataById(empId);
		ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id:", payrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/addperson")
	public EmployeePayrollData addPerson(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		return employeePayrollService.addPerson(employeePayrollDTO);
	}
	
	//curl -X POST -H "Content-Type: application/json" -d '{"name": "Lisa","salary":2000}' "http://localhost:8080/employeepayrollservice/create" -w "\n"
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
		logger.debug("Employee payroll dto "+employeePayrollDTO.toString());
		EmployeePayrollData payrollData = null;
		payrollData = employeePayrollService.createEmployeePayrollData(employeePayrollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Employee payroll data for:", payrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	

	// curl -X PUT -H "Content-Type: application/json" -d '{"name": "bhushan","salary": 21000}' "http://localhost:8080/employeepayrollservice/update/1" -w "\n"
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
			@RequestBody EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData updateEmployeePayrollData = null;
		updateEmployeePayrollData = employeePayrollService.updateEmployeePayrollData(empId, employeePayrollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Employee payroll Data for: ", updateEmployeePayrollData);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	//curl -X DELETE -H "Content-Type: application/json" localhost:8080/employeepayrollservice/delete/1 -w "\n"
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDTO responseDTO = new ResponseDTO("Delete Call Success for id: ", "empId " + empId);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
//	localhost:8080/employeepayrollservice/department/HR
//	@GetMapping("/department/{department}")
//	public ResponseEntity<ResponseDTO> getEmployeesByDepartment(@PathVariable("department") String department) {
//		List<EmployeePayrollData> employeesByDepartment = employeePayrollService.getEmployeesByDepartment(department);
//		ResponseDTO responseDTO = new ResponseDTO("Get call for the department success ", employeesByDepartment);
//		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
//	}

}
