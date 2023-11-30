package com.employee.service.impl;

import java.util.ArrayList;
import java.util.List;import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.entity.EmployeeEntity;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto dto) {

		EmployeeEntity entity= new EmployeeEntity();
		BeanUtils.copyProperties(dto, entity);
		EmployeeEntity savedEntity = employeeRepository.save(entity);
	
		 BeanUtils.copyProperties(savedEntity, dto);
		 return dto;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		 List<EmployeeEntity> entitylist = employeeRepository.findAll();
		
		 List<EmployeeDto> dtoList= new ArrayList<>();
		 entitylist.stream().forEach(entity->{
			                                 EmployeeDto dto = new EmployeeDto();
		                                     BeanUtils.copyProperties(entity, dto); 
		                                     dtoList.add(dto);
		                                      });
		 return dtoList;
			 
		    /*
			 * List<EmployeeDto> dtoList = entitylist.stream() .map(entity->{
			 *                                                               EmployeeDto dto = new EmployeeDto();
			 *                                                               BeanUtils.copyProperties(entity, dto); 
			 *                                                               return dto;
			 *                                                              }).collect(Collectors.toList()); 
			 *                                                              return dtoList;
			 */
		 
	}

	@Override
	public EmployeeDto getOneEmployeeById(Integer id) {
		
	     EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Exists"));
	
	    EmployeeDto dto = new EmployeeDto();
	    BeanUtils.copyProperties(employeeEntity, dto);
	    return dto;
	}

	@Override
	public List<EmployeeDto> deleteEmployeeById(Integer id) {
		
		EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Exists"));
		
		employeeRepository.delete(employeeEntity);
		
		 List<EmployeeEntity> entityList = employeeRepository.findAll();
		 List<EmployeeDto> dtoList = entityList.stream() .map(entity->{
			                                                            EmployeeDto dto = new EmployeeDto();
			                                                            BeanUtils.copyProperties(entity, dto); 
			                                                            return dto;
			                                                            }).collect(Collectors.toList()); 
		return dtoList;
			 
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto dto) {
		
		 Integer id = dto.getId();
		 
		 EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee Not Exists"));
		 
		  EmployeeEntity updatedEntity = employeeRepository.save(employeeEntity);
		  
		  BeanUtils.copyProperties(employeeEntity, dto);
		return dto;
		}

	

	

}
