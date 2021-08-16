package com.koreait.shoppingmall.model.repository.payment;

import java.util.List;

import com.koreait.shoppingmall.domain.PayMethod;

public interface PayMethodService {
	public List selectAll();
	public PayMethod select(int paymethod_id);
	public void insert(PayMethod paymethod);
	public void update(PayMethod paymethod);
	public void delete(int paymethod_id);	
}