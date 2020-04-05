package com.lawencon.ticketing.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.ticketing.model.Transaction;
import com.lawencon.ticketing.service.TransactionServiceImpl;

@RestController
public class TransactionCtrl {
	@Autowired
	TransactionServiceImpl trxServImpl;

	@PostMapping("/trx/insert")
	public ResponseEntity<String> insertTrx(@RequestBody Transaction trx){
		try {
			trxServImpl.insertTrx(trx);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal" , HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil" , HttpStatus.OK);
	}
	
	@PostMapping("/trx/delete")
	public ResponseEntity<String> deleteTrx(@RequestParam Long id){
		try {
			trxServImpl.deleteTrx(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal" , HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil" , HttpStatus.OK);
	}
	
	@GetMapping("/trx/show")
	public ResponseEntity<List<Transaction>> showTrx(){
		List<Transaction> listTrx = new ArrayList<>();
		try {
			listTrx = trxServImpl.showTrx();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listTrx , HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listTrx , HttpStatus.OK);
		
	}
}
