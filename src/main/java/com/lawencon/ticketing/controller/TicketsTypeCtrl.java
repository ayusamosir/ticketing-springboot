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

import com.lawencon.ticketing.model.TicketType;
import com.lawencon.ticketing.service.TicketTypeServiceImpl;

@RestController
public class TicketsTypeCtrl {
	
	@Autowired
	TicketTypeServiceImpl ticTypeServImpl;

	@PostMapping("/tictype/insert")
	public ResponseEntity<String> insertTickType (@RequestBody TicketType tickType){
		try {
			ticTypeServImpl.insertTickType(tickType);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil" , HttpStatus.OK);
	}
	
	@PostMapping("/ticktype/update")
	public ResponseEntity<String> updateTickType (@RequestParam ("id") Long id){
		try {
			ticTypeServImpl.updateTickType(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/ticktype/delete")
	public ResponseEntity<String> deleteTickType (@RequestParam ("id") Long id){
		try {
			ticTypeServImpl.deleteTickType(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.OK);
	}
	
	public ResponseEntity<List<TicketType>> showTickType (){
		List<TicketType> listTickType = new ArrayList<>();
		try {
			listTickType = ticTypeServImpl.showTickType();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listTickType, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listTickType, HttpStatus.OK);
	}
}
