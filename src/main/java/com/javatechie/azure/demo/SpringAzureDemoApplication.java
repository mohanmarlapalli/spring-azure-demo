package com.javatechie.azure.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringAzureDemoApplication {

	@GetMapping("/message")
	public String message(){
		return "Congrats ! your application deployed successfully in Azure Platform. !";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAzureDemoApplication.class, args);
	}
	
	 @Autowired
	    private EmployeeRepository repository;

	    @PostMapping("/employee")
	    public Employee addEmployee(@RequestBody Employee1 employee) {
	    	Employee emp = new Employee();
	    	emp.setDept(employee.getDept());
	    	emp.setName(employee.getName());
	    	emp.setSalary(employee.getSalary());
	        return repository.save(emp);
	    }

	    @GetMapping("/employees")
	    public List<Employee> getEmployees() {
	        return repository.findAll();
	    }



}
