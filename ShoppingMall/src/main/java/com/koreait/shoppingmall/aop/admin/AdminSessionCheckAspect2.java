package com.koreait.shoppingmall.aop.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;

import com.koreait.shoppingmall.exception.LoginFailException;

//관리자기능을 이루는 모든 페이지마다 , 또는 컨트롤러의 모든 메서드 마다 세션을 검증하는 코드를 일일이 작성하지 말고,
//공통로직으로 두고, AOP를 적용하여 개발의 효율성을 높이자..

//아까 예제에서의 Bell과 같은 녀석임..
public class AdminSessionCheckAspect2 {
	//관리자와 즉 admin으로 시작하는 모든  요청 URI를 세션의 검증대상으로 보지말고, 로그인이 필요치 않는 요청에 대해서는 
	//그냥 가던길 가게 해주자!!
	// proceed() 이후에 즉 원래 호출하려면 메서드의 반환값이 있을 경우엔 아래의 메서드의 return을 이용하여 반환해야 함..
	public Object sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Object[] args=joinPoint.getArgs(); //타겟 객체의 메서드 요청시 넘어오는 매개변수들을 잡아냄
		HttpServletRequest request=null;
		HttpSession session=null;
		
		for(Object obj : args) {
			if(obj instanceof HttpServletRequest) {
				request =(HttpServletRequest)obj;
			}
		}
		
		String uri = request.getRequestURI();
		
		Object result=null; 
		if(uri.equals("/admin/loginform") 
				|| uri.equals("/admin/login") 
				|| uri.equals("/admin/kkkk")){
			//검증이 필요하지 않은 경우
			result=joinPoint.proceed(); //원래의 메서의 호출 후, 그 반환값을 받는다
		}else {
			//검증이 필요한 경우	
			session=request.getSession();
			if(session.getAttribute("admin")==null) {
				throw new LoginFailException("로그인이 필요한 서비스입니다");
			}else {
				result=joinPoint.proceed();//로그인 검증을 거친사람은 원래 호출하려던 메서드 호출해줘야 함 
			}
		}
		return result;
	}
}
