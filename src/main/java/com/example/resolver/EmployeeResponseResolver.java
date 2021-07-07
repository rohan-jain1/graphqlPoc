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
