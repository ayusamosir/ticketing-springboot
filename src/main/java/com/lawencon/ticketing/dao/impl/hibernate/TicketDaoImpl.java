package com.lawencon.ticketing.dao.impl.hibernate;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.dao.TicketsDao;
import com.lawencon.ticketing.model.Discount;
import com.lawencon.ticketing.model.TicketType;
import com.lawencon.ticketing.model.Tickets;

@Repository("tick_repo_hiber")
public class TicketDaoImpl extends BaseHibernate implements TicketsDao{

	@Override
	public Tickets insertTicket(Tickets ticket) throws Exception {
		TicketType tickType = new TicketType();
		if(tickType.getType()!=null) {
			Discount disc = new Discount();
			disc.getDiscount();
			ticket.setDepartDate(LocalDate.now());
			if(disc.getCodeVouc()!=null) {
				ticket.setPrice(tickType.getPrice()-disc.getDiscount());
			}else {
				ticket.setPrice(tickType.getPrice());
			}
		}
		em.persist(ticket);
		return ticket;
	}

	@Override
	public Tickets updateTicket(Long id) throws Exception {
		Query q = em.createQuery(" from Tickets where id = :idParam");
		q.setParameter("idParam", id);
		Tickets tick = new Tickets();
		tick = (Tickets) q.getSingleResult();
		em.merge(tick);
		return tick;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tickets> showTicket() throws Exception {
		Query q = em.createQuery(" from Tickets ");
		return q.getResultList();
	}

	@Override
	public void deleteTicket(Long id) throws Exception {
		Query q = em.createQuery(" from Tickets where id = :idParam");
		q.setParameter("idParam", id);
		Tickets tick = new Tickets();
		tick = (Tickets) q.getSingleResult();
		em.remove(tick);
	}

}
