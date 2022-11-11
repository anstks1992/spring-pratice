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
	public String form2(@ModelAttribute("mbean")@Valid MemberBean mb, BindingResult result ) {//����üũ, �ݵ�� �� ������� �� ��			       
		
		String page = "result"; //������ ������ result.jsp�� ���� 
		System.out.println(result.hasErrors()); //true(�����Ǿ���), false(��������)
		if(result.hasErrors()) {
			page = "form"; //������ ������ form���� ����
		}
		return page;	
	}
}
