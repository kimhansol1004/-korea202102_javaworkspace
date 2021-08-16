package com.koreait.shoppingmall.exception;

public class OrderDetailException extends RuntimeException{
	
	public OrderDetailException(String msg) {
		super(msg);
	}
	
	public OrderDetailException(Throwable e) {
		super(e);
	}
	
	public OrderDetailException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
