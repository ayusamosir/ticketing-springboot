package com.lawencon.ticketing.dao;

import java.util.List;

import com.lawencon.ticketing.model.Customer;

public interface CustomerDao {
	
	abstract Customer insertCustomer(Customer custom) throws Exception;

	abstract Customer updateCustomer(Long id) throws Exception;

	abstract List<Customer> showCustomer() throws Exception;

	abstract void deleteCustomer(Long id) throws Exception;

}
