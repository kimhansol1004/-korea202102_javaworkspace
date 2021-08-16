package com.koreait.shoppingmall.controller.rest.study;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.shoppingmall.domain.Member;

//RESTful 요청을 처리하기 위한 연습용 컨트롤러 
@RestController
public class StudyController {

	//멤버 목록에 대한 요청 처리
	@GetMapping("/member")
	//@ResponseBody //이 어노테이션을 명시하면, ViewResolver 에 의해 jsp매핑이 일어나지 않고, 반환된 데이터 자체를 응답정보로 사용하게 됨.
	public List<Member> getList() {
		//제이슨 객체   List<Member>를 자동으로 Json으로 변환하여 응답데이터로 전송... 
		//string 화 시킴..(외부 라이브러리 의존 Gson.class..) - 불편함. 스프링에서는 자바 객체를 json으로 자동변환해주는 컨버터를 지원함..
		//우리는 이 컨버터는 spring빈 설정파일에 이미 등록해놓았다..
		Member m1=new Member();
		m1.setMember_id(1);
		m1.setUser_id("scott");
		m1.setPass("0000");
		m1.setName("스캇");
		
		Member m2=new Member();
		m2.setMember_id(2);
		m2.setUser_id("adams");
		m2.setPass("2222");
		m2.setName("아담스");
		
		List<Member> list=new ArrayList<Member>();
		list.add(m1);
		list.add(m2);
		
		return list;
	}
	
	//멤버 한건 가져오기 
	@GetMapping("/member/{member_id}") //경로에 불과했던 member_id를 , 실제 변수화 시켜주기 위해서는 
	//@ResponseBody									//@PathVariable을 써야한다!!
	public Member getDetail(@PathVariable int member_id){ //url의 일부가 아닌,  RESTful에서의 변수임을 알려주자!
		System.out.println("member_id="+member_id);
		Member m=new Member();
		
		m.setMember_id(member_id);
		m.setUser_id("king");
		m.setPass("9999");
		m.setName("킹");
		
		return m;
	}
	
	//폼양식으로부터 글 등록 요청(post) 처리
	
	 //member_id=5&user_id=zino&pass=000
	/*
	@PostMapping("/member")
	public Member regist(Member member) {
		System.out.println("post요청 처리");
		return member;
	}
	*/
	
	/*  {"member_id":24} 형식의 문자열로 전송되어옴
	 일반적으로 특별한 처리를 하지 않는 한, VO매핑은 query string 만을
	 매핑시킨다.즉 json문자열과의 매핑은 일어나지 않음 
	 해결책 : @RequestBody  : 제이슨 문자열을 자바객체와 매핑시켜줌
	 */
	
	@PostMapping("/member")
	public Member regist(@RequestBody Member member) {
		System.out.println("이름은 "+member.getName());
		return member;
	}
	
	
	//글 등록 요청(put) 처리 
	@PutMapping("/member")
	public Member update(@RequestBody Member member) {
		System.out.println("put 요청 처리함");
		member.setName("putter");
		return member;
	}
	
	@DeleteMapping("/member")
	public Member delete(@RequestBody Member member) {
		System.out.println("delete 요청 처리");
		return member;
	}
	
}











