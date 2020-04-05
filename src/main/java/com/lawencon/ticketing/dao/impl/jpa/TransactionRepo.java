package com.lawencon.ticketing.dao.impl.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.model.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long>{

}
