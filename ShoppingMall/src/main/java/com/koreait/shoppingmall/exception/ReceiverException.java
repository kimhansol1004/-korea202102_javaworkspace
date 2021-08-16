package com.koreait.shoppingmall.exception;

public class ReceiverException extends RuntimeException{
	
	public ReceiverException(String msg) {
		super(msg);
	}
	
	public ReceiverException(Throwable e) {
		super(e);
	}
	
	public ReceiverException(String msg, Throwable e) {
		super(msg, e);
	}
	
}
