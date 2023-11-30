package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDto;
import com.employee.entity.EmployeeEntity;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

   @Autowired
	private  EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeEntity> createEmployee( @RequestBody EmployeeDto employee)
    {
		EmployeeEntity employee1 = employeeService.saveEmployee(employee);
		return new ResponseEntity<EmployeeEntity>(employee1 ,HttpStatus.ACCEPTED);

		
	}

	@GetMapping("/employee/all")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployees()
	{
		
		List<EmployeeEntity> list = employeeService.getAllEmployees();
		return new ResponseEntity<List<EmployeeEntity>>(list ,HttpStatus.ACCEPTED);
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<?>  getOneEmployee(@PathVariable Integer id)
	{
		
		try {
			 EmployeeEntity employee = employeeService.getOneEmployeeById(id);
			return new ResponseEntity<EmployeeEntity>(employee ,HttpStatus.ACCEPTED);

		} catch (EmployeeNotFoundException e) {
			return new ResponseEntity<String>( e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable Integer id)
	{
		
		try {
			employeeService.deleteEmployeeById(id);
			List<EmployeeEntity> list = employeeService.getAllEmployees();
			return new ResponseEntity<List<EmployeeEntity>>(list ,HttpStatus.ACCEPTED);
		} catch (EmployeeNotFoundException e) {
			
			return new ResponseEntity<String>( e.getMessage(),HttpStatus.BAD_REQUEST);
			//If we use Global Exception Handler,then we can use "throw e" instead of above line
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?>   updateEmployee( @RequestBody EmployeeDto employee) {
		
		try {
			EmployeeEntity employee1 = employeeService.updateEmployee(employee);
			return new ResponseEntity<EmployeeEntity>(employee1 ,HttpStatus.ACCEPTED);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<String>( e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
}
	
	
}