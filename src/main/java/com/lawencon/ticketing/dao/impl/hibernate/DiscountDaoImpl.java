package com.lawencon.ticketing.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.ticketing.dao.DiscountDao;
import com.lawencon.ticketing.model.Discount;
import com.lawencon.ticketing.model.TicketType;

@Repository("disc_repo_hiber")
public class DiscountDaoImpl extends BaseHibernate implements DiscountDao{

	@Override
	public Discount insertDisc(Discount disc) throws Exception {
		TicketType tickTye = new TicketType();
		tickTye.getType();
		disc.setTicketType(tickTye);
		em.persist(disc);
		return disc;
	}

	@Override
	public Discount updateDisc(Long id) throws Exception {
		Query q = em.createQuery(" from Discount where id = :idParam");
		q.setParameter("idParam", id);
		Discount disc = new Discount();
		disc = (Discount) q.getSingleResult();
		em.merge(disc);
		return disc;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Discount> showDisc() throws Exception {
		Query q = em.createQuery(" from Discount ");
		return q.getResultList();
	}

	@Override
	public void deleteDisc(Long id) throws Exception {
		Query q = em.createQuery(" from Discount where id = :idParam");
		q.setParameter("idParam", id);
		Discount disc = new Discount();
		disc = (Discount) q.getSingleResult();
		em.remove(disc);
	}
	
	
}
