package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDto;
import com.employee.entity.EmployeeEntity;

public interface EmployeeService {
	
	public EmployeeDto saveEmployee(EmployeeDto dto);
	
	public List<EmployeeDto> getAllEmployees();
	
	public EmployeeDto getOneEmployeeById(Integer id);
	
	public List<EmployeeDto> deleteEmployeeById(Integer id);
	
	public EmployeeDto updateEmployee(EmployeeDto dto);

}
