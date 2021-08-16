package com.koreait.shoppingmall.controller.client.shopping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.shoppingmall.domain.OrderSummary;
import com.koreait.shoppingmall.domain.Receiver;
import com.koreait.shoppingmall.model.repository.payment.PayMethodService;
import com.koreait.shoppingmall.model.service.payment.OrderService;
import com.koreait.shoppingmall.model.service.product.CartService;

@Controller
public class PaymentController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private PayMethodService payMethodService;
	
	@Autowired
	private OrderService orderService;
	
	
	//결제 페이지 요청 처리 
	@GetMapping("/checkout/form")
	public ModelAndView getForm(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("client/shop/checkout");
		//장바구니 목록 가져가야 함..
		//HttpSession session=request.getSession();
		//Member member=(Member)session.getAttribute("member");
		//cartService.selectAllJoin(member.getMember_id());
		List cartList=cartService.selectAllJoin(1);
		mav.addObject("cartList", cartList);
		
		//결제 방법 담기 
		List payMethodList = payMethodService.selectAll();
		mav.addObject("payMethodList", payMethodList);
		
		return mav;
	}
	
	//결제요청 
	@PostMapping("/checkout/pay")
	public ModelAndView pay(HttpServletRequest request, OrderSummary orderSummary, Receiver receiver) {
		System.out.println("orderSummary= "+orderSummary);
		System.out.println("receiver= "+receiver);
		
		//HttpSession session=request.getSession();
		//Member member=(Member)session.getAttribute("member");
		//cartService.selectAllJoin(member.getMember_id());
		orderSummary.setMember_id(1); // 테스트 단계에서는 1로 고정함 
		
		//주문요약  insert 
		
		//주문상세  insert 
		
		//배송정보  insert 
		orderService.regist(orderSummary, receiver);
		
		return null;
	}
	
}












