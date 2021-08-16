package com.koreait.shoppingmall.controller.rest.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.shoppingmall.domain.Cart;
import com.koreait.shoppingmall.domain.Message;
import com.koreait.shoppingmall.exception.CartException;
import com.koreait.shoppingmall.model.service.product.CartService;


@RestController
public class CartController {
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CartService cartService;
	
	//장바구니에 1건 담기
	@RequestMapping(value="/cart", method=RequestMethod.POST, produces="application/json;charset=utf-8")  //RESTful 하다, 즉 rest를 준수함
	@ResponseBody // java객체를 자동으로 json으로 변경
	public ResponseEntity<Message> insert(@RequestBody Cart cart) { //json 으로 받아야 함

		cartService.insert(cart);
		//if(true)throw new CartException("장바구니 일부러 에러");
		
		//Spring Http응답정보 ResponseEntity 전용 객체를 이용하여, 응답정보를 구성함
		Message message=new Message();
		message.setMsg("장바구니 담기 성공 !!");
		message.setResultCode(1); //개발자가 임의로 정한것
		ResponseEntity<Message> entity=new ResponseEntity<Message>(message, HttpStatus.OK);
		
		return entity;
	}
	
	@ExceptionHandler(CartException.class)
	@ResponseBody
	public ResponseEntity<Message> handle(CartException e) {
		Message message  =new Message();
		message.setMsg(e.getMessage());
		message.setResultCode(0); //개발자가 임의로 정한것
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message, HttpStatus.OK);
		return entity;
	}
}




