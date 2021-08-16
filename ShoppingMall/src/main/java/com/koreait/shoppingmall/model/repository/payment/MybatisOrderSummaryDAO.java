package com.koreait.shoppingmall.model.repository.payment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.shoppingmall.domain.OrderSummary;
import com.koreait.shoppingmall.exception.OrderSummaryException;

@Repository
public class MybatisOrderSummaryDAO implements OrderSummaryDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
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
	public void insert(OrderSummary orderSummary) throws OrderSummaryException{
		int result=sqlSessionTemplate.insert("OrderSummary.insert", orderSummary);
		if(result==0) {
			throw new OrderSummaryException("주문 요약 등록에 실패");
		}
		
	}

	@Override
	public void update(OrderSummary orderSummary)  throws OrderSummaryException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int order_summary_id)  throws OrderSummaryException{
		// TODO Auto-generated method stub
		
	}
	
}