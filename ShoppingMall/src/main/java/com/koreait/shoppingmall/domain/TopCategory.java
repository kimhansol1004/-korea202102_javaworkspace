package com.koreait.shoppingmall.domain;

import java.util.List;

import lombok.Data;

@Data
public class TopCategory {
	private int topcategory_id;
	private String top_name;
	private int cnt;
	private List<SubCategory> subList;//부모가 거느리고 있는 자식객체들을 보유할 리스트 선언		
}
