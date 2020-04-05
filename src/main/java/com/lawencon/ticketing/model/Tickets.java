package com.lawencon.ticketing.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="tb_m_ticket")
public class Tickets {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "chair_numb")
	private String noChair;
	
	@Column(name = "depart_date")
	private LocalDate departDate;
	
	private Long prices;
	
	public Long getPrice() {
		return prices;
	}
	
	public void setPrice(Long vou) {
		this.prices = vou;
	}
	
	@OneToOne
	@JoinColumn(name = "disc_id")
	private Discount disc;
	
	public Discount getDisc() {
		return disc;
	}
	
	public void setDisc(Discount disc) {
		this.disc = disc;
	}
	
	@OneToOne
	@JoinColumn(name = "type_id")
	private TicketType tickType;
	
	public TicketType getTickType() {
		return tickType;
	}

	public void setTickType(TicketType tickType) {
		this.tickType = tickType;
	}

	@ManyToOne
	@JoinColumn(name = "trx_id")
	private Transaction trx;
	
	public Transaction getTrx() {
		return trx;
	}

	public void setTrx(Transaction trx) {
		this.trx = trx;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNoChair() {
		return noChair;
	}

	public void setNoChair(String noChair) {
		this.noChair = noChair;
	}

	public LocalDate getDepartDate() {
		return departDate;
	}

	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}
	
}
