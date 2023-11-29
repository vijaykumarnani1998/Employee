package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity employee) {
	
		return employeeRepository.save(employee);
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeEntity getOneEmployeeById(Integer id) {
		
		 Optional<EmployeeEntity> optEmployee = employeeRepository.findById(id);
		 EmployeeEntity employeeEntity = optEmployee.get();
		 return employeeEntity;
	}

	@Override
	public List<EmployeeEntity> deleteEmployeeById(Integer id) {
		employeeRepository.deleteById(id); 
		return getAllEmployees() ;
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employee) {
		
		return employeeRepository.save(employee);
	}

}