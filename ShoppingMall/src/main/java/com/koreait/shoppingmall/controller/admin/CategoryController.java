package com.koreait.shoppingmall.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.shoppingmall.domain.SubCategory;
import com.koreait.shoppingmall.model.service.category.SubCategoryService;
import com.koreait.shoppingmall.model.service.category.TopCategoryService;

//관리자가 보게될 상품의 카테고리와 관련된 요청처리 하위컨트롤러
@Controller
public class CategoryController {

	@Autowired
	private TopCategoryService topCategoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	//카테고리 목록 
	@RequestMapping(value="/category/list", method=RequestMethod.GET)
	public String getCategoryList(Model model,HttpServletRequest request) {
		System.out.println("getCategoryList 호출");
		
		//3단계: 일 시키기
		List topList=topCategoryService.getSubCount();
		
		//4단계: 결과저장
		model.addAttribute("topList", topList);
		
		
		return "admin/category/index";
	}
	
	//상위 카테고리의 상세내역 요청 처리 
	@RequestMapping(value="/category/topdetail", method=RequestMethod.GET)
	@ResponseBody
	public List<SubCategory> getTopDetail(int topcategory_id, Model model,HttpServletRequest request) {
		//3단계: 일시키기 
		List subList=subCategoryService.selectAllById(topcategory_id);
		
		//4단계: 결과저장 
		//model.addAttribute("subList", subList); //forwaring needed...
		//jsp를 통해서가 아니라, 현재 요청 메서드에서 응답자체를 json, xml 등으로 처리할 수 있는 방법
		//자바객체를 자동으로 json표기법으로 String화시켜 자동변환해주는 라이브러리를 스프링은 이용할수 있다..
		
		return subList;
	}
	
	
}




















