package com.koreait.shoppingmall.aop.client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.shoppingmall.model.service.category.TopCategoryService;

/*
  클라이언트의 쇼핑몰 이용시 모든 페이지에 사용될 카테고리를 공통 코드로 처리해본다
 */
public class TopCategoryAspect {
	@Autowired
	private TopCategoryService topCategoryService;
	
	public Object getList(ProceedingJoinPoint joinPoint) throws Throwable{
		Object result=null;
		HttpServletRequest request=null;
		
		
		Object[] args=joinPoint.getArgs();
		
		//매개변수들 중 HttpServletRequest 를 끄집어 내자!!
		for(Object obj : args) {
			if(obj instanceof HttpServletRequest) {
				request = (HttpServletRequest)obj;
			}
		}
		
		String uri = request.getRequestURI();
		if(uri.equals("/client/shop/member/registform") || 
			uri.equals("/client/shop/member/regist")
				
		) {
			result=joinPoint.proceed();
		}else {
			//카테고리 목록이 필요한 요청일 경우...
			List topList = topCategoryService.selectChild();
			Object returnObj = joinPoint.proceed(); //ModelAndView의 주소값을 사용할 수있다는 것은
			//곧, 그 객체에 무언가를 심을 수 있다는 뜻이다...
			ModelAndView mav=null;
			if(returnObj instanceof ModelAndView) {
				mav=(ModelAndView)returnObj;
				mav.addObject("topList", topList);
				result=mav;
			}
		}
		return result;
	}
}