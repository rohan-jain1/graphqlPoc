package com.example.response;

import java.util.List;

import com.example.entity.Address;
import com.example.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponse {

	private long id;

	private String firstName;

	private String lastName;
	
	private String email; 
	
	private List<AddressResponse> addresses;

//	private List<SubjectResponse> learningSubjects; //todo remove
	
	// this is for internal use. DO NOT PUT IN SCHEMA
	private Student student;
	
	private String fullName;
	
	public StudentResponse (Student student) {
		this.student = student;
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
				
		/*if (student.getLearningSubjects() != null) {
			learningSubjects = new ArrayList<SubjectResponse>();
			for (Subject subject: student.getLearningSubjects()) {
				learningSubjects.add(new SubjectResponse(subject));
			}
		}*/
	}

}
