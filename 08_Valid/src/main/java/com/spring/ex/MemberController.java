package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@RequestMapping(value="form", method = RequestMethod.GET) 
	public String form1() {			       
		return "form";	
}
	@RequestMapping(value="form",method = RequestMethod.POST) 
	public String form2(@ModelAttribute("mbean")@Valid MemberBean mb, BindingResult result ) {//누락체크, 반드시 이 순서대로 할 것			       
		
		String page = "result"; //문제가 없으면 result.jsp로 가라 
		System.out.println(result.hasErrors()); //true(누락되었다), false(문제없다)
		if(result.hasErrors()) {
			page = "form"; //문제가 있으면 form으로 가라
		}
		return page;	
	}
}
