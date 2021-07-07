package com.example.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.entity.Address;
import com.example.response.AddressResponse;
import com.example.response.StudentResponse;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

//	public List<SubjectResponse> getLearningSubjects (StudentResponse studentResponse,
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
	
	public List<AddressResponse> getAddresses(StudentResponse studentResponse) {
		
		
		List<AddressResponse> addresses = new ArrayList<AddressResponse>();
		if(studentResponse.getStudent().getAddresses() != null) {
			for(Address address: studentResponse.getStudent().getAddresses()) {
				addresses.add(new AddressResponse(address));
			}
		}
		
		return addresses;
	}
	
	public String getFullName (StudentResponse studentResponse) {
		return studentResponse.getFirstName() + " " + studentResponse.getLastName();
	}
}
