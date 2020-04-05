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

import com.lawencon.ticketing.model.Tickets;
import com.lawencon.ticketing.service.TicketsServiceImpl;

@RestController
public class TicketsCtrl {
	
	@Autowired
	TicketsServiceImpl tickServImpl;
	
	@PostMapping("/tickets/insert")
	public ResponseEntity<String> insertTick(@RequestBody Tickets tick) {
		try {
			tickServImpl.insertTicket(tick);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.OK);

	}
	
	@PostMapping("/tickets/update")
	public ResponseEntity<String> updateTick(@RequestParam Long id){
		try {
			tickServImpl.updateTicket(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.OK);
	}
	
	@PostMapping("/tickets/delete")
	public ResponseEntity<String> deleteTick(@RequestParam Long id){
		try {
			tickServImpl.deleteTicket(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil", HttpStatus.OK);
	}
	
	@GetMapping("/tickets/show")
	public ResponseEntity<List<Tickets>> showTick (){
		List<Tickets> listTick = new ArrayList<>();
		try {
			listTick = tickServImpl.showTicket();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listTick, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listTick, HttpStatus.OK);
		
	}
	
}

