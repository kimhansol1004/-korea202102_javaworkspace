package com.koreait.shoppingmall.model.repository.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.shoppingmall.domain.Cart;
import com.koreait.shoppingmall.exception.CartException;
import com.koreait.shoppingmall.exception.DMLException;

@Repository
public class MybatisCartDAO implements CartDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insert(Cart cart) throws CartException{
		int result = sqlSessionTemplate.insert("Cart.insert", cart);
		if(result==0) {
			throw new DMLException("장바구니에 등록 실패");
		}
	}

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Cart.selectAll");
	}

	@Override
	public List selectAllJoin(int member_id) {
		return sqlSessionTemplate.selectList("Cart.selectAll", member_id);
	}

	@Override
	public void update(Cart cart) throws CartException{
		int result = sqlSessionTemplate.insert("Cart.update", cart);
		if(result==0) {
			throw new DMLException("장바구니 수정 실패");
		}
	}

	@Override
	public void delete(int cart_id) throws CartException{
		int result = sqlSessionTemplate.insert("Cart.delete", cart_id);
		if(result==0) {
			throw new DMLException("장바구니 삭제 실패");
		}
		
	}

	@Override
	public void deleteAll(int member_id) throws CartException{
		int result = sqlSessionTemplate.insert("Cart.deleteAll", member_id);
		if(result==0) {
			throw new DMLException("장바구니 비우기 실패");
		}
	}
	
}