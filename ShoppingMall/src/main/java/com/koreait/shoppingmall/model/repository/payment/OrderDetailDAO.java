package com.koreait.shoppingmall.model.repository.payment;

import java.util.List;

import com.koreait.shoppingmall.domain.OrderDetail;

public interface OrderDetailDAO {
	public List selectAll();
	public OrderDetail select(int order_detail_id);
	public void insert(OrderDetail orderDetail);
	public void update(OrderDetail orderDetail);
	public void delete(int order_detail_id);	
}