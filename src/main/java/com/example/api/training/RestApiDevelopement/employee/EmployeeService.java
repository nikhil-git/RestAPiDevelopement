package com.example.api.training.RestApiDevelopement.employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	//List of employees
		@GetMapping(path= "/employees")
		public List<Employee> getEmployees() {
			
			
			  List<Employee> employees = Arrays.asList(new Employee(1,"Nikhil","nikhil@test.com"), new
			  Employee(2,"Amuthan","amu@test.com")
			  
			  
			  
			  );
			 
			employeeRepository.saveAll(employees);
			return employeeRepository.findAll();
			
		}
		
		public Optional<Employee> getEmployee(int id) {
			
			return employeeRepository.findById(id);
			
		}

		public Employee addEmployee(Employee employee) {
			if(employeeRepository.existsById(employee.getId())) {
				throw new IllegalStateException("Id already exists");
			}
			 employeeRepository.save(employee);
			 return employee;
		}

		public String deleteEmployee(int id) {
			if(!employeeRepository.existsById(id)) {
				throw new IllegalStateException("Id not exists");
			}
			employeeRepository.deleteById(id);
			return "success";
		}

		public Employee editEmployee(Employee employee,int id) {
			if(!employeeRepository.existsById(id)) {
				throw new IllegalStateException("Id not exists");
			}
			employeeRepository.deleteById(id);
			employeeRepository.save(employee);
			return employee;
		}

		public List<Employee> getEmployeeMatchingQuery(int limit) {
			
			return employeeRepository.findAll().stream().limit(limit).collect(Collectors.toList());
		}
	
	
}
