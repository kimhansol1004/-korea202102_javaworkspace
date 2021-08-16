package com.koreait.shoppingmall.domain;

import lombok.Data;

@Data
public class OrderDetail {
	private int order_detail_id;
	private int order_summary_id; //fk
	private int product_id; //fk
	private int ea;
	private int price; //상품 테이블참조 X, 구매당시의 가격
	
	//조인
	private OrderSummary orderSummary;
	private Product product;
	
}
