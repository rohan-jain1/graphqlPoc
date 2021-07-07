package com.example.query;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.entity.Employee;
import com.example.request.SampleRequest;
import com.example.response.EmployeeResponse;
import com.example.service.EmployeeService;

@Component
public class Query implements GraphQLQueryResolver {
	
	@Autowired
	EmployeeService employeeService;

	public String firstQuery () {
		return "First Query";
	}
	
	public String secondQuery () {
		return "Second Query";
	}
	
	public String fullName (SampleRequest sampleRequest) {
		return sampleRequest.getFirstName() + " " + sampleRequest.getLastName();
	}
	
	public EmployeeResponse getEmployee (long id) {
		return new EmployeeResponse(employeeService.getEmployeeById(id));
	}
	
	
	public List<EmployeeResponse> getAllEmployees() {
		List<Employee> employeeList = employeeService.getAllEmployees();
		List<EmployeeResponse> empResponseList = new ArrayList<EmployeeResponse>();
		if(employeeList != null) {
			for(Employee emp : employeeList) {
				empResponseList.add(new EmployeeResponse(emp));
			}
			
			return empResponseList;
		}
		return null;
	}
}
