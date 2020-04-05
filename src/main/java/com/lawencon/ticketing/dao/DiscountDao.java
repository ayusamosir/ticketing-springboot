package com.lawencon.ticketing.dao;

import java.util.List;

import com.lawencon.ticketing.model.Discount;

public interface DiscountDao {
	
	abstract Discount insertDisc(Discount disc) throws Exception;

	abstract Discount updateDisc(Long id) throws Exception;

	abstract List<Discount> showDisc() throws Exception;

	abstract void deleteDisc(Long id) throws Exception;
}
