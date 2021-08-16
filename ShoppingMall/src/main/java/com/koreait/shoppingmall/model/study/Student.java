package com.koreait.shoppingmall.model.study;

//학생을 느슨하게 보유하기 위해서 인터페이스로 정의
public interface Student {
	public void getup(int time); //시간을 매개변수로 갖는 메서드
	public void study(String subject); //과목을 매개변수로 갖는 메서드
	public void sleep();
}
