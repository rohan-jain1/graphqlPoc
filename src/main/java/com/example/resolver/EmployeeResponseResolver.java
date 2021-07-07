package com.example.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.entity.Address;
import com.example.response.AddressResponse;
import com.example.response.EmployeeResponse;

@Service
public class EmployeeResponseResolver implements GraphQLResolver<EmployeeResponse> {

//	public List<SubjectResponse> getLearningSubjects (EmployeeResponse studentResponse,
//			SubjectNameFilter subjectNameFilter) {
//		
//		List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();
//		
//		if (studentResponse.getStudent().getLearningSubjects() != null) {
//			for (Subject subject: studentResponse.getStudent().getLearningSubjects()) {
//				if (subjectNameFilter.name().equalsIgnoreCase("ALL")) {
//					learningSubjects.add(new SubjectResponse(subject));
//				} else if (subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())) {
//					learningSubjects.add(new SubjectResponse(subject));
//				}
//			}
//		}
//		
//		return learningSubjects;
//		
//	}
	
	public List<AddressResponse> getAddresses(EmployeeResponse employeeResponse) {
		
		
		List<AddressResponse> addresses = new ArrayList<AddressResponse>();
		if(employeeResponse.getEmployee().getAddresses() != null) {
			for(Address address: employeeResponse.getEmployee().getAddresses()) {
				addresses.add(new AddressResponse(address));
			}
		}
		
		return addresses;
	}
	
	public String getFullName (EmployeeResponse employeeResponse) {
		return employeeResponse.getFirstName() + " " + employeeResponse.getLastName();
	}
}
