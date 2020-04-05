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

import com.lawencon.ticketing.model.Customer;
import com.lawencon.ticketing.service.CustomerServiceImpl;

@RestController
public class CustomerCtrl {
	
	@Autowired
	CustomerServiceImpl custServImpl;

	@PostMapping("/customer/insert")
	public ResponseEntity<String> insertCustom (@RequestBody Customer cust){
		try {
			custServImpl.insertCustomer(cust);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.OK);	
	}
	
	@PostMapping("/customer/update")
	public ResponseEntity<String> updateCustom (@RequestParam("id") Long id){
		try {
			custServImpl.updateCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST); 
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/customer/delete")
	public ResponseEntity<String> deleteCustom (@RequestParam("id") Long id){
		try {
			custServImpl.deleteCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.OK);
	}
	
	@GetMapping("/customer/show")
	public ResponseEntity<List<Customer>> showCustom (){
		List<Customer> listCustom = new ArrayList<>();
		try {
			listCustom = custServImpl.showCustomer();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listCustom, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listCustom, HttpStatus.OK);
	}

}