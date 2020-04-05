package com.lawencon.ticketing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_disc")
public class Discount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true, name = "code_voucher")
	private String codeVouc; 
	
	@OneToOne
	@JoinColumn(name = "ticket_id")
	TicketType ticketType;
	
	private Long discount;
	
	public Long getDiscount() {
		return discount;
	}
	
	public void setDiscount(Long discount) {
		this.discount=discount;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeVouc() {
		return codeVouc;
	}

	public void setCodeVouc(String codeVouc) {
		this.codeVouc = codeVouc;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}
	
	
}
