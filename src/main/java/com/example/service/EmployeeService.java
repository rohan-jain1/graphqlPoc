package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.repository.AddressRepository;
import com.example.repository.EmployeeRepository;
import com.example.request.CreateAddressRequest;
import com.example.request.CreateEmployeeRequest;

@Service
public class EmployeeService {

	@Autowired
	AddressRepository addressRepository;
	
//	@Autowired
//	SubjectRepository subjectRepository; //todo remove
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee getEmployeeById (long id) {
		return employeeRepository.findById(id).get();
	}
	
	public Employee createEmployee (CreateEmployeeRequest createEmployeeRequest) {
		Employee employee = new Employee(createEmployeeRequest);
		
		
		employee = employeeRepository.save(employee);
		
		
		List<Address> addressList = new ArrayList<Address>();
		
		if(createEmployeeRequest.getAddresses() != null) {
			for(CreateAddressRequest addressReq : createEmployeeRequest.getAddresses()) {
				Address address = new Address();
				address.setCity(addressReq.getCity());
				address.setStreet(addressReq.getStreet());
				address.setEmployee(employee);
				addressList.add(address);
				
			}
		}
		addressRepository.saveAll(addressList);
		employee.setAddresses(addressList);
		
//		List<Subject> subjectsList = new ArrayList<Subject>();
//		
//		if(createStudentRequest.getSubjectsLearning() != null) {
//			for (CreateSubjectRequest createSubjectRequest : 
//					createStudentRequest.getSubjectsLearning()) {
//				Subject subject = new Subject();
//				subject.setSubjectName(createSubjectRequest.getSubjectName());
//				subject.setMarksObtained(createSubjectRequest.getMarksObtained());
//				subject.setStudent(student);
//				
//				subjectsList.add(subject);
//			}
//			
//			subjectRepository.saveAll(subjectsList);
//			
//		}
//		
//		student.setLearningSubjects(subjectsList);
//		
		return employee;
	}
}
