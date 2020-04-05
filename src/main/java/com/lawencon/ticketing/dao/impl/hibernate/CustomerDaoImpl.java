package com.lawencon.ticketing.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.dao.CustomerDao;
import com.lawencon.ticketing.model.Customer;

@Repository("cust_repo_hiber")
public class CustomerDaoImpl extends BaseHibernate implements CustomerDao {

	@Override
	public Customer insertCustomer(Customer custom) throws Exception {
		em.persist(custom);
		return custom;
	}

	@Override
	public Customer updateCustomer(Long id) throws Exception {
		Query q = em.createQuery(" from Customer where id = :idParam");
		q.setParameter("idParam", id);
		Customer custom = new Customer();
		custom = (Customer) q.getSingleResult();
		em.merge(custom);
		return custom;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> showCustomer() throws Exception {
		Query q = em.createQuery(" from Customer");
		return q.getResultList();
	}

	@Override
	public void deleteCustomer(Long id) throws Exception {
		Query q = em.createQuery(" from Customer where id = :idParam");
		q.setParameter("idParam", id);
		Customer custom = new Customer();
		custom = (Customer) q.getSingleResult();
		em.remove(custom);
	}

}
