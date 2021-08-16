package com.koreait.shoppingmall.exception;

public class OrderSummaryException extends RuntimeException{
	
	public OrderSummaryException(String msg) {
		super(msg);
	}
	
	public OrderSummaryException(Throwable e) {
		super(e);
	}
	
	public OrderSummaryException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
