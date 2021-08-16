package com.koreait.shoppingmall.model.service.product;

import java.util.List;

import com.koreait.shoppingmall.domain.Cart;

public interface CartService {
	public void insert(Cart cart);
	public List selectAll();
	public List selectAllJoin(int member_id); //Product와 조인하여 가져오기 
	public void update(Cart cart);
	public void delete(int cart_id);
	public void deleteAll(int member_id);
}