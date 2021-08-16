package com.koreait.shoppingmall.domain;

import lombok.Data;

@Data
public class Receiver {
	private int receiver_id;
	private int order_summary_id; //fk 
	private String name;
	private String addr1;
	private String addr2;
	private String phone1;//국번
	private String phone2;//앞자리
	private String phone3;//뒷자리
	
	//조인 
	private OrderSummary orderSummary;
}