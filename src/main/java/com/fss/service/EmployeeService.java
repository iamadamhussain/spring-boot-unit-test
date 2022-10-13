package com.fss.service;

import java.util.List;

import com.fss.model.Employee;

public interface EmployeeService
{
	public  Employee createEmployee(Employee employee);

	public  void updateEmployee(Employee employee);
	
	public  Employee getEmployee(int id);
	
	public  List<Employee> getEmployees();
	
	public  void deleteEmployee(int id);
	
	public  boolean isEmployeeExist(int id);
}
