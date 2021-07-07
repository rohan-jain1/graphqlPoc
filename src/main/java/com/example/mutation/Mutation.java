package com.example.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.request.CreateEmployeeRequest;
import com.example.response.EmployeeResponse;
import com.example.service.EmployeeService;

@Service
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	EmployeeService employeeService;
	
	public EmployeeResponse createEmployee (CreateEmployeeRequest createEmployeeRequest) {
		return new EmployeeResponse(employeeService.createEmployee(createEmployeeRequest));
	}
}
