package com.zuchol.webstore.data.repository;

import java.util.List;

import com.zuchol.webstore.domain.Customer;

public interface CustomerRepository {

	List<Customer> getAllCustomers();
}
