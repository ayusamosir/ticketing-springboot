package com.lawencon.ticketing.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.dao.TransactionDao;
import com.lawencon.ticketing.model.Customer;
import com.lawencon.ticketing.model.Transaction;

@Repository("trx_repo_jpa")
public class TransactionDaoImpl implements TransactionDao{
	
	@Autowired
	TransactionRepo trxRepo;

	@Override
	public Transaction insertTrx(Transaction trx) throws Exception {
		Customer cust = new Customer();
		cust.getId();
		trx.setCustomer(cust);
		return trxRepo.save(trx);
	}

	@Override
	public void deleteTrx(Long id) throws Exception {
		trxRepo.deleteById(id);	
	}

	@Override
	public List<Transaction> showTrx() throws Exception {
		return trxRepo.findAll();
	}

}
