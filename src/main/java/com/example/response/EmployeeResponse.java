package com.example.response;

import java.util.List;

import com.example.entity.Address;
import com.example.entity.Employee;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeResponse {

	private long id;

	private String firstName;

	private String lastName;
	
	private String email; 
	
	private List<AddressResponse> addresses;

//	private List<SubjectResponse> learningSubjects; //todo remove
	
	// this is for internal use. DO NOT PUT IN SCHEMA
	private Employee employee;
	
	private String fullName;
	
	public EmployeeResponse (Employee employee) {
		this.employee = employee;
		this.id = employee.getId();
		this.firstName = employee.getFirstName();
		this.lastName = employee.getLastName();
		this.email = employee.getEmail();
				
		/*if (employee.getLearningSubjects() != null) {
			learningSubjects = new ArrayList<SubjectResponse>();
			for (Subject subject: employee.getLearningSubjects()) {
				learningSubjects.add(new SubjectResponse(subject));
			}
		}*/
	}

}
