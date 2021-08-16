package com.koreait.shoppingmall.model.repository.product;

import java.util.List;

import com.koreait.shoppingmall.domain.Cart;

public interface CartDAO {
	public void insert(Cart cart);
	public List selectAll();
	public List selectAllJoin(int member_id);  
	public void update(Cart cart);
	public void delete(int cart_id);
	public void deleteAll(int member_id); //Cart안에 member_id 들어있기 때문에
}
