package com.fss.repository;

import org.springframework.data.repository.CrudRepository;

import com.fss.model.Employee;  

public interface EmployeeRepository extends CrudRepository<Employee, Integer>
{

}
