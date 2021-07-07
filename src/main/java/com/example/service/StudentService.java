package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Address;
import com.example.entity.Student;
import com.example.repository.AddressRepository;
import com.example.repository.StudentRepository;
import com.example.request.CreateAddressRequest;
import com.example.request.CreateStudentRequest;

@Service
public class StudentService {

	@Autowired
	AddressRepository addressRepository;
	
//	@Autowired
//	SubjectRepository subjectRepository; //todo remove
	
	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudentById (long id) {
		return studentRepository.findById(id).get();
	}
	
	public Student createStudent (CreateStudentRequest createStudentRequest) {
		Student student = new Student(createStudentRequest);
		
//		Address address = new Address();
//		address.setStreet(createStudentRequest.getStreet());
//		address.setCity(createStudentRequest.getCity());
//		
//		address = addressRepository.save(address);
		
//		student.setAddresses(address);
		
		student = studentRepository.save(student);
		
		
		List<Address> addressList = new ArrayList<Address>();
		
		if(createStudentRequest.getAddresses() != null) {
			for(CreateAddressRequest addressReq : createStudentRequest.getAddresses()) {
				Address address = new Address();
				address.setCity(addressReq.getCity());
				address.setStreet(addressReq.getStreet());
				address.setStudent(student);
				addressList.add(address);
				
			}
		}
		addressRepository.saveAll(addressList);
		student.setAddresses(addressList);
		
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
		return student;
	}
}
