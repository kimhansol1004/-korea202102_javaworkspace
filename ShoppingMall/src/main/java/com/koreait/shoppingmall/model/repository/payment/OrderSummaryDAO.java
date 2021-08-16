package com.koreait.shoppingmall.model.repository.payment;

import java.util.List;

import com.koreait.shoppingmall.domain.OrderSummary;

	public interface OrderSummaryDAO {
		public List selectAll();
		public OrderSummary select(int order_summary_id);
		public void insert(OrderSummary orderSummary);
		public void update(OrderSummary orderSummary);
		public void delete(int order_summary_id);
		

}
