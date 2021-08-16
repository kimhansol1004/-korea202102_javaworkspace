  
package com.koreait.shoppingmall.model.repository.payment;

import java.util.List;

import com.koreait.shoppingmall.domain.Receiver;

public interface ReceiverDAO {
	public List selectAll();
	public Receiver select(int receiver_id);
	public void insert(Receiver receiver);
	public void update(Receiver receiver);
	public void delete(int receiver_id);
	
}