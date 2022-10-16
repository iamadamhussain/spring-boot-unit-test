package com.fss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fss.model.Employee;
import com.fss.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "API to search Student from a Employee Repository by different search parameters",
description = "This API provides the capability to search Employee from a Employee Repository", produces = "application/json")
public class EmployeeServiceController {
	@Autowired
	private EmployeeService employeeService;
	   @ApiOperation(value = "create Student", produces = "application/json")
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
		employee = employeeService.createEmployee(employee);
		return new ResponseEntity<>("Employee is created successfully with id = " + employee.getId(),
				HttpStatus.CREATED);
	}
	   @ApiOperation(value = "updated employee by empId", produces = "application/json")
	@RequestMapping(value = "/updateemployee/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {

		employee.setId(id);
		employeeService.updateEmployee(employee);
		return new ResponseEntity<>("Employee is updated successsfully", HttpStatus.OK);

	}
	    @ApiOperation(value = "get for  employee by id", produces = "application/json")
	@RequestMapping(value = "/getemployees/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployee(@PathVariable("id") int id) {
		boolean isEmployeeExist = employeeService.isEmployeeExist(id);

		Employee employee = employeeService.getEmployee(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);

	}
	    @ApiOperation(value = "get all employees", produces = "application/json")
	@RequestMapping(value = "/listemployees", method = RequestMethod.GET)
	public ResponseEntity<Object> getEmployees() {
		List<Employee> employeeList = employeeService.getEmployees();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}
	    @ApiOperation(value = "delete employee by id", produces = "application/json")
	@RequestMapping(value = "/deleteemployee/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id) {

		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Employee is deleted successsfully", HttpStatus.OK);

	}

}
