package com.koreait.shoppingmall.model.service.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.shoppingmall.domain.OrderSummary;
import com.koreait.shoppingmall.domain.Receiver;
import com.koreait.shoppingmall.exception.OrderSummaryException;
import com.koreait.shoppingmall.model.repository.payment.OrderDetailDAO;
import com.koreait.shoppingmall.model.repository.payment.OrderSummaryDAO;
import com.koreait.shoppingmall.model.repository.payment.ReceiverDAO;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderSummaryDAO orderSummaryDAO;
	
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderSummary select(int order_summary_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void regist(OrderSummary orderSummay, Receiver receiver) throws OrderSummaryException{
		//3개의 DAO를 통해서 트랜잭션 업무로 엮어야 한다!!!(스프링 설정에서...)
		orderSummaryDAO.insert(orderSummay);
	}

	@Override
	public void update(OrderSummary orderSummay) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int order_summary_id) {
		// TODO Auto-generated method stub
		
	}
	
}