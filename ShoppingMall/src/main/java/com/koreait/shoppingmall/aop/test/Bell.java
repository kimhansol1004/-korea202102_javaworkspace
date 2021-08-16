package com.koreait.shoppingmall.aop.test;

import org.aspectj.lang.ProceedingJoinPoint;

//어플리케이션 어디에서나 사용가능한 공통로직
public class Bell {
	
	//공통로직
	//공통로직을 around advice로 호출할 경우, 원래 호출하려 했던 메서드를 도달하기전 각종 정보를 낚아챌수 있다..
	//이때 각종 정보를 가진 객체가 바로 ProceedingJoinPoint 이다~!!
	public void sound(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("호출전 딩동댕♬");
		
		Object target = joinPoint.getTarget(); //원래 호출되려했던 객체...
		//System.out.println("중간에 낚아채서 알아낸 정보 중 원래 호출될 객체는 "+target);
		
		//원래 호출하려던 타겟 객체의 메서드의 매개변수로 알아맞춰보자 
		String methodName=joinPoint.getSignature().getName(); //원래 호출하려면 메서드의 이름
		System.out.println("원래 호출하려고 했던 메서드명은 "+methodName);
		
		Object[] args=joinPoint.getArgs();
		for( Object obj : args) {
			System.out.println(obj);
		}
		
		//원래 호출하려 햇던 메서드 다시 호출재개
		joinPoint.proceed(); //go ahead ~~~ 가던 길 가시오
		
		System.out.println("호출후 딩동댕♬");
	}
}
