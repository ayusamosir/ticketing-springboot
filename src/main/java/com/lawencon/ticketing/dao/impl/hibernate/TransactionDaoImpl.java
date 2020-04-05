package com.lawencon.ticketing.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.dao.TransactionDao;
import com.lawencon.ticketing.model.Customer;
import com.lawencon.ticketing.model.Transaction;

@Repository("trx_repo_hiber")
public class TransactionDaoImpl extends BaseHibernate implements TransactionDao {

	@Override
	public Transaction insertTrx(Transaction trx) throws Exception {
		Customer cust = new Customer();
		cust.getId();
		trx.setCustomer(cust);
		em.persist(trx);
		return trx;
	}

	@Override
	public void deleteTrx(Long id) throws Exception {
		Query q = em.createQuery(" from Transaction where id = :idParam");
		q.setParameter("idParam", id);
		Transaction trx = new Transaction();
		trx = (Transaction) q.getSingleResult();
		em.remove(trx);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> showTrx() throws Exception {
		Query q = em.createQuery(" from Transaction ");
		return q.getResultList();
	}

}
