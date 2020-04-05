package com.lawencon.ticketing.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.ticketing.dao.CustomerDao;
import com.lawencon.ticketing.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	@Qualifier("cust_repo_jpa")
	CustomerDao custDao;
	
	@Override
	public Customer insertCustomer(Customer custom) throws Exception {
		return custDao.insertCustomer(custom);
	}

	@Override
	public Customer updateCustomer(Long id) throws Exception {
		return custDao.updateCustomer(id);
	}

	@Override
	public List<Customer> showCustomer() throws Exception {
		return custDao.showCustomer();
	}

	@Override
	public void deleteCustomer(Long id) throws Exception {
		custDao.deleteCustomer(id);
		
	}

}
