package com.example.api.training.RestApiDevelopement.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	//List of employees
			@GetMapping(path= "/employees")
			public List<Employee> getEmployees() {
				return employeeService.getEmployees();
				
			}
			
			@GetMapping(path= "/employees/{id}")
			public Optional<Employee> getEmployee(@PathVariable int id) {
				return employeeService.getEmployee(id);
				
			}
			
			@GetMapping(path= "/employees1")
			public List<Employee> getEmployeeMatchingQuery(@RequestParam(required = false) int limit) {
				return employeeService.getEmployeeMatchingQuery(limit);
			}
			
			@PostMapping(path= "/employees")
			public Employee addEmployee(@RequestBody Employee employee) {
				
				return employeeService.addEmployee(employee);
			}
			
			@DeleteMapping(path= "/employees/{id}")
			public String deleteEmployee(@PathVariable int id) {
				return employeeService.deleteEmployee(id);
				
			}
			
			@PutMapping(path= "/employees/{id}")
			public Employee editEmployee(@RequestBody Employee employee,@PathVariable int id) {
				return employeeService.editEmployee(employee,id);
				
			}
			
			}


