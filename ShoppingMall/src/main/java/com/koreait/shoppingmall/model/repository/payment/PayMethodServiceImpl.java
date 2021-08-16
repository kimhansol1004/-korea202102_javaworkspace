package com.koreait.shoppingmall.model.repository.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.koreait.shoppingmall.domain.PayMethod;

@Service
public class PayMethodServiceImpl implements PayMethodService{
	@Autowired
	private PayMethodDAO payMethodDAO;
	
	@Override
	public List selectAll() {
		return payMethodDAO.selectAll();
	}

	@Override
	public PayMethod select(int paymethod_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(PayMethod paymethod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PayMethod paymethod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int paymethod_id) {
		// TODO Auto-generated method stub
		
	}
	
}