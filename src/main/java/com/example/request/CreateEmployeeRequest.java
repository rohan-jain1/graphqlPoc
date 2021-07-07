package com.example.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateEmployeeRequest {

	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;
	
	private List<CreateAddressRequest> addresses;

//	private List<CreateSubjectRequest> subjectsLearning;

}
