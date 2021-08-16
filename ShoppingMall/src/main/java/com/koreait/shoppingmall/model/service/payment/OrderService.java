package com.koreait.shoppingmall.model.service.payment;

import java.util.List;

import com.koreait.shoppingmall.domain.OrderDetail;
import com.koreait.shoppingmall.domain.OrderSummary;
import com.koreait.shoppingmall.domain.Receiver;

public interface OrderService {
	
	public List selectAll();
	public OrderSummary select(int order_summary_id);
	public void regist(OrderSummary orderSummay,Receiver receiver); //3개의 테이블에 걸쳐, 업무를 진행할 예정..
	public void update(OrderSummary orderSummay);
	public void delete(int order_summary_id);
	
}