package com.lawencon.ticketing.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.ticketing.dao.TransactionDao;
import com.lawencon.ticketing.model.Transaction;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	@Qualifier("trx_repo_jpa")
	TransactionDao trxDao;
	
	@Override
	public Transaction insertTrx(Transaction trx) throws Exception {
		return trxDao.insertTrx(trx);
	}

	@Override
	public void deleteTrx(Long id) throws Exception {
		trxDao.deleteTrx(id);	
	}

	@Override
	public List<Transaction> showTrx() throws Exception {
		return trxDao.showTrx();
	}

}
