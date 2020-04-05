package com.lawencon.ticketing.service;

import java.util.List;

import com.lawencon.ticketing.model.Transaction;

public interface TransactionService {
	abstract Transaction insertTrx(Transaction trx) throws Exception;

	abstract void deleteTrx(Long id) throws Exception;
	
	abstract List<Transaction> showTrx() throws Exception;
}
