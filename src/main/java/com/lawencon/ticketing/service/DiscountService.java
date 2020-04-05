package com.lawencon.ticketing.service;

import java.util.List;

import com.lawencon.ticketing.model.Discount;

public interface DiscountService {
	abstract Discount insertDisc(Discount disc) throws Exception;

	abstract Discount updateDisc(Long id) throws Exception;

	abstract List<Discount> showDisc() throws Exception;

	abstract void deleteDisc(Long id) throws Exception;

}
