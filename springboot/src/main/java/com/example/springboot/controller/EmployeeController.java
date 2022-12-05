package com.example.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.Employee1;
import com.example.springboot.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@GetMapping("/employees")
	public List<Employee1> getAllEmployees(){
		return employeeRepository.findAll();
	}	
	
	
	
	
	@PostMapping("/employees")
	public Employee1 createEmployee(@RequestBody Employee1 employee) {
		return employeeRepository.save(employee);
	}
	
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee1> getEmployeeById(@PathVariable Long id) {
		Employee1 employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	
	
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee1> updateEmployee(@PathVariable Long id, @RequestBody Employee1 employeeDetails){
		
		System.out.println("id="+id);
		Employee1 employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setName(employeeDetails.getName());
		employee.setSalary(employeeDetails.getSalary());
		employee.setDepartment(employeeDetails.getDepartment());
		
		Employee1 updatedEmployee = employeeRepository.save(employee);
		System.out.println(employee+"!!!!!!!!!!!!!update!!!!!!!!!");
		return ResponseEntity.ok(updatedEmployee);
	}
	

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee1> deleteEmployee(@PathVariable Long id){
		Employee1 employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		 employeeRepository.delete(employee);
		 System.out.println(employee+"!!!!!!!!!!!!!!!!!!!!!!");
		 return ResponseEntity.ok(employee);
		 
	}
	
	
}
