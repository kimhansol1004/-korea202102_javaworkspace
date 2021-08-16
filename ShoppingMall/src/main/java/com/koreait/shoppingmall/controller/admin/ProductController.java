package com.koreait.shoppingmall.controller.admin;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.shoppingmall.domain.Product;
import com.koreait.shoppingmall.exception.FileHandleException;
import com.koreait.shoppingmall.exception.UploadException;
import com.koreait.shoppingmall.model.common.file.FileManager;
import com.koreait.shoppingmall.model.service.category.TopCategoryService;
import com.koreait.shoppingmall.model.service.product.ProductService;

//상품관련 요청을 처리하는 하위 컨트롤러
@Controller
public class ProductController {
	@Autowired
	private TopCategoryService topCategoryService;	
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private ProductService productService;
	
	//상품 등록폼 요청처리 
	@GetMapping("/product/registform")
	public String registForm(Model model,HttpServletRequest request) {
		//3단계: 최상위 카테고리 가져오기 
		List topList = topCategoryService.selectAll();
		
		//4단계:결과저장 
		model.addAttribute("topList", topList);
		
		return "admin/product/regist";//상품 등록 폼 뷰이름
	}
	
	//상품 등록 요청(파일업로드가 포함되어 있슴)
	@PostMapping("/product/regist")
	public String regist(Product product, HttpServletRequest request) {
		
		//VO에 등록한 MultipartFile 객체에 업로드된 파일이 이미 들어있으므로, 개발자는 이 객체를 이용하여 업로드된 파일을
		//원하는대로 제어하면 된다..
		MultipartFile photo=product.getPhoto();
		ServletContext context = request.getServletContext();
		long time=System.currentTimeMillis();
		
		//서비스.regist();
		//원하는 위치에 파일 저장하기
		String filename=time+"."+fileManager.getExt(photo.getOriginalFilename());
		
		fileManager.saveFile(context,filename , photo);
		product.setProduct_img(filename); //insert 직전에 파일명 결정짓기
		productService.regist(product);
		
		return "redirect:/admin/product/list"; //상품 목록페이지를 재요청
	}
	
	//모든 상품 가져오기 
	@GetMapping("/product/list")
	public String getList(Model model, HttpServletRequest request) {
		//3단계: 일시키기
		List productList = productService.selectAll();
		
		//4단계:저장
		model.addAttribute("productList", productList);
		
		return "admin/product/product_list";
	}
	
	//상품 상세보기 요청 
	@GetMapping("/product/detail")
	public String getDetail(int product_id, Model model, HttpServletRequest request) {
		//3단계:
		Product product = productService.select(product_id);
		List topList=topCategoryService.selectAll();
		
		//4단계: 
		model.addAttribute("product", product);
		model.addAttribute("topList", topList);
		
		return "admin/product/content";
	}
	
	//상품 삭제요청 처리 
	@PostMapping("/product/del")
	public String delete(Product product, HttpServletRequest request){
		//3단계
		productService.delete(product.getProduct_id());
		fileManager.deleteFile(request.getServletContext(), product.getProduct_img());
		
		return "redirect:/admin/product/list"; //리스트에 재요청
	}
	
	
	
	@ExceptionHandler(UploadException.class)
	public String handleException(UploadException e, Model model) {
		model.addAttribute("e", e);//에러 객체 담기 
		return "error/result";
	}
	
	@ExceptionHandler(FileHandleException.class)
	public String handleException(FileHandleException e, Model model) {
		model.addAttribute("e", e);//에러 객체 담기 
		return "error/result";
	}
	
}









