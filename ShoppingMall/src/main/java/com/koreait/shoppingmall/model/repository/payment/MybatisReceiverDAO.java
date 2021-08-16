package com.koreait.shoppingmall.model.repository.payment;

import java.util.List;

import com.koreait.shoppingmall.domain.Receiver;
import com.koreait.shoppingmall.exception.ReceiverException;

public class MybatisReceiverDAO implements ReceiverDAO{

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Receiver select(int receiver_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Receiver receiver)  throws ReceiverException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Receiver receiver)  throws ReceiverException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int receiver_id)  throws ReceiverException {
		// TODO Auto-generated method stub
		
	}
	
}