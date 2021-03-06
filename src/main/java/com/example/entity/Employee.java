package com.example.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.request.CreateEmployeeRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "employee")
	private List<Address> addresses;
	
//	@OneToMany(mappedBy = "employee") // todo remove
//	private List<Subject> learningSubjects;
	
	public Employee (CreateEmployeeRequest createEmployeeRequest) {
		this.firstName = createEmployeeRequest.getFirstName();
		this.lastName = createEmployeeRequest.getLastName();
		this.email = createEmployeeRequest.getEmail();
	}
}
