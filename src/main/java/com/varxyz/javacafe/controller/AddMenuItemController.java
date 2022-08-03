package com.varxyz.javacafe.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.varxyz.javacafe.domain.BigCategory;
import com.varxyz.javacafe.domain.Image;
import com.varxyz.javacafe.domain.MenuItem;
import com.varxyz.javacafe.domain.MenuItemCommand;
import com.varxyz.javacafe.servive.MenuItemServiceImp;
import com.varxyz.javacafe.servive.menuItemService;

@Controller
public class AddMenuItemController {
	
	@Autowired
	MenuItemServiceImp menuItemService;
	
	@GetMapping("/menuitem/add_menuitem")
	public String addMenuItemForm() {
		return "menuitem/add_menuitem";
	}
	
	@GetMapping("/main")
	public String toMain() {
		return "main";
	}
	
	@ModelAttribute("catgegoryProvider")
	public List<CategoryProvider> getCategoryProviderList() {
		List<CategoryProvider> list = menuItemService.getCategoryProvider();
		return list;
		
	}
	
	
	
	@PostMapping("/menuitem/add_menuitem")
	public String addMenuItem(Model model, HttpServletRequest request, @RequestParam("report") MultipartFile report) throws IOException {
//		model.addAttribute("menuItemCommand", menuItemCommand);
		MenuItem menuItem = new MenuItem();
		String menuName = request.getParameter("menuName");
		double menuPrice = Double.parseDouble(request.getParameter("menuPrice"));
		String bigCategoryName = request.getParameter("bigCategoryName");
		menuItem.setMenuName(menuName);
		menuItem.setMenuPrice(menuPrice);
		menuItem.setBigCategoryName(new BigCategory(bigCategoryName));
		
		String filePath = "C:\\ncs\\eclipse\\workspace\\java-cafe\\src\\main\\webapp\\resources\\menuImg\\";
		
        //파일명
        String originalFile = report.getOriginalFilename();
        System.out.println(originalFile);
        //파일명 중 확장자만 추출                                                //lastIndexOf(".") - 뒤에 있는 . 의 index번호
        String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
        //fileuploadtest.doc
        //lastIndexOf(".") = 14(index는 0번부터)
        //substring(14) = .doc
        
        //업무에서 사용하는 리눅스, UNIX는 한글지원이 안 되는 운영체제 
        //파일업로드시 파일명은 ASCII코드로 저장되므로, 한글명으로 저장 필요
        //UUID클래스 - (특수문자를 포함한)문자를 랜덤으로 생성                    "-"라면 생략으로 대체
        String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
        
        Image img = new Image();
        img.setImgName(storedFileName);
        img.setImgOriName(originalFile);
        img.setImgUrl(filePath);
        menuItemService.addMenuItem(menuItem, img);
        request.setAttribute("menuitem", menuItem);
        request.setAttribute("imgName", storedFileName);
        
        //파일을 저장하기 위한 파일 객체 생성
        File file = new File(filePath + storedFileName);
        //파일 저장
        report.transferTo(file);
        
        System.out.println(menuItem + "가 업로드한 파일은");
        System.out.println(originalFile + "은 업로드한 파일이다.");
        System.out.println(storedFileName + "라는 이름으로 업로드 됐다.");
        System.out.println("파일사이즈는 " + report.getSize());
		return "menuitem/add_success_menuitem";
	}
	
	
	
}