package com.lawencon.ticketing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_trx")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trx_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Customer customer;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Customer getCustomr() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
