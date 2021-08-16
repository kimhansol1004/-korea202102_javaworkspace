package com.koreait.shoppingmall.model.repository.payment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.shoppingmall.domain.PayMethod;

@Repository
public class MybatisPayMethodDAO implements PayMethodDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("PayMethod.selectAll");
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