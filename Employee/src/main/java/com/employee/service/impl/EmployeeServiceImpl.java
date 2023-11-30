package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;
import com.employee.exception.EmployeeNotFoundException;
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
		
	EmployeeEntity employeeEntity = employeeRepository.findById(id)
			                                          .orElseThrow(()->new EmployeeNotFoundException("Employee Not Exists"));
	 return employeeEntity;
	}

	@Override
	public List<EmployeeEntity> deleteEmployeeById(Integer id) {
		EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Exists"));
		if(employeeEntity!=null)
		{
		employeeRepository.deleteById(id); 
		return getAllEmployees() ;
		}
		else
		{
			return null;
		}
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employee) {
		//findById(user.getId()).get();
		Integer id = employee.getId();
		Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
		
		if(employeeEntity.isPresent())
		{
		return employeeRepository.save(employee);
		}
		else {
			throw new  EmployeeNotFoundException("Employee Not Exists");

		}
	}

}
