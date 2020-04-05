package com.lawencon.ticketing.dao.impl.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.dao.CustomerDao;
import com.lawencon.ticketing.model.Customer;

@Repository("cust_repo_jpa")
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	CustomerRepo custRepo;
	
	@Override
	public Customer insertCustomer(Customer custom) throws Exception {
		return custRepo.save(custom);
	}

	@Override
	public Customer updateCustomer(Long id) throws Exception {
		List<Customer> listCust = new ArrayList<>();
		listCust = custRepo.findAllById(id);
		if(listCust.get(0).getName()!= null) {
			Customer cust = new Customer();
			cust.setName(listCust.get(0).getName());
			cust.setAddress(listCust.get(0).getAddress());
			custRepo.save(cust);
			return cust;
		}
		return null;
	}

	@Override
	public List<Customer> showCustomer() throws Exception {
		return custRepo.findAll();
	}

	@Override
	public void deleteCustomer(Long id) throws Exception {
		custRepo.deleteById(id);
	}

}
