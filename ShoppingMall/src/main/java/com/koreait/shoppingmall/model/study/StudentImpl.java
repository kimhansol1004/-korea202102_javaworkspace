package com.koreait.shoppingmall.model.study;

import org.springframework.stereotype.Component;

public class StudentImpl implements Student{
	
	public void getup(int time) {
		System.out.println(time+"시에 기상합니다");
	}

	@Override
	public void study(String subject) {
		System.out.println(subject+"를 공부합니다");
	}

	@Override
	public void sleep() {
		System.out.println("취침합니다");
	}	
}
