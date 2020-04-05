package com.lawencon.ticketing.dao.impl.hibernate;

import java.util.List;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.dao.TicketTypeDao;
import com.lawencon.ticketing.model.TicketType;

@Repository("ticktype_repo_hiber")
public class TicketTypeDaoImpl extends BaseHibernate implements TicketTypeDao {

	@Override
	public TicketType insertTickType(TicketType ticketType) throws Exception {
		em.persist(ticketType);
		return ticketType;
	}

	@Override
	public TicketType updateTickType(Long id) throws Exception {
		Query q = em.createQuery(" from Tickets where id = :idParam");
		q.setParameter("idParam", id);
		TicketType tickType = new TicketType();
		tickType = (TicketType) q.getSingleResult();
		em.merge(tickType);
		return tickType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketType> showTickType() throws Exception {
		Query q = em.createQuery(" from Tickets ");
		return q.getResultList();
	}

	@Override
	public void deleteTickType(Long id) throws Exception {
		Query q = em.createQuery(" from Tickets where id = :idParam");
		q.setParameter("idParam", id);
		TicketType tickType = new TicketType();
		tickType = (TicketType) q.getSingleResult();
		em.remove(tickType);
		
	}

}
