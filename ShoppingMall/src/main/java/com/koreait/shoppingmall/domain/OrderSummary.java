package com.koreait.shoppingmall.domain;

import lombok.Data;

@Data
public class OrderSummary {
	private int order_summery_id;
	private int member_id;
	private String order_date;
	private int total_buy;
	private int total_pay;
	private int paymethod_id;
	
	//조인
	private Member member;
	private PayMethod patmethod;
}
