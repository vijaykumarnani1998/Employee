package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.EmployeeEntity;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
		return this.employeeService.saveEmployee(employee);
	}

	@GetMapping("/employee/all")
	public List<EmployeeEntity> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@DeleteMapping("/employee/{id}")
	public List<EmployeeEntity> deleteEmployeeById(@PathVariable Integer id) {
		employeeService.deleteEmployeeById(id);
		return employeeService.getAllEmployees();
	}

	@PutMapping("/update")
	public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity) {

		return employeeService.updateEmployee(employeeEntity);
}
	
	
}