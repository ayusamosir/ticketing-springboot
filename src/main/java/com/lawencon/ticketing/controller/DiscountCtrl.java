package com.lawencon.ticketing.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.ticketing.model.Discount;
import com.lawencon.ticketing.service.DiscountServiceImpl;

@RestController
public class DiscountCtrl {
	
	@Autowired
	DiscountServiceImpl discServImpl;
	
	@PostMapping("/discount/insert")
	public ResponseEntity<String> insertDisc (@RequestBody Discount disc){
		try {
			discServImpl.insertDisc(disc);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.OK);	
	}
	
	@PostMapping("/discount/update")
	public ResponseEntity<String> updateDisc (@RequestParam("id") Long id){
		try {
			discServImpl.updateDisc(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/discount/delete")
	public ResponseEntity<String> deleteDisc (@RequestParam("id") Long id){
		try {
			discServImpl.deleteDisc(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.OK);
	}
	
	public ResponseEntity<List<Discount>> showDisc(){
		List<Discount> listDisc = new ArrayList<>();
		try {
			listDisc = discServImpl.showDisc();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listDisc, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listDisc,HttpStatus.OK);
		
	}
	
	
	
}
