package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDto;
import com.employee.entity.EmployeeEntity;

public interface EmployeeService {
	
	public EmployeeEntity saveEmployee(EmployeeDto dto);
	
	public List<EmployeeEntity> getAllEmployees();
	
	public EmployeeEntity getOneEmployeeById(Integer id);
	
	public List<EmployeeEntity> deleteEmployeeById(Integer id);
	
	public EmployeeEntity updateEmployee(EmployeeDto dto);

}
