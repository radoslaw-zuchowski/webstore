package com.zuchol.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zuchol.webstore.data.repository.CustomerRepository;
import com.zuchol.webstore.domain.Customer;
import com.zuchol.webstore.service.CustomerSevice;

@Service
public class CustomerServiceImpl implements CustomerSevice{

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}
}
