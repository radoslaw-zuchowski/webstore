package com.zuchol.webstore.data.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zuchol.webstore.data.repository.CustomerRepository;
import com.zuchol.webstore.domain.Customer;


@Repository
public class InMemoryCustomRepository implements CustomerRepository {

	private List<Customer> listOfCustomers = new ArrayList<Customer>();
	
	
	public InMemoryCustomRepository() {
		
		Customer customer1 = new Customer(1, "Ewelinka");
		customer1.setAddress("Poznań");
		customer1.setNoOfOrdersMade(0);
		
		Customer customer2 = new Customer(2, "Radek");
		customer2.setAddress("Wrocław");
		customer2.setNoOfOrdersMade(0);
		
		listOfCustomers.add(customer1);
		listOfCustomers.add(customer2);
		
		
	}
	
	
	public List<Customer> getAllCustomers() {
		return listOfCustomers;
	}
	
}
