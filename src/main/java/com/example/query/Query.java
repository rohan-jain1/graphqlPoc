package com.example.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
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
	
}
