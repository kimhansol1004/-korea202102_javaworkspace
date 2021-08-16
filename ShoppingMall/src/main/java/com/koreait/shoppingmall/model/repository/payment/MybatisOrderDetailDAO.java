package com.koreait.shoppingmall.model.repository.payment;

import java.util.List;

import com.koreait.shoppingmall.domain.OrderDetail;
import com.koreait.shoppingmall.exception.OrderDetailException;

public class MybatisOrderDetailDAO implements OrderDetailDAO{

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetail select(int order_detail_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(OrderDetail orderDetail)  throws OrderDetailException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OrderDetail orderDetail)  throws OrderDetailException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int order_detail_id)  throws OrderDetailException{
		// TODO Auto-generated method stub
		
	}
	
}