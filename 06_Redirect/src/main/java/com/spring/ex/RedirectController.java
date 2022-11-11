package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

	@RequestMapping(value="/a1") 
	public String a1(HttpServletRequest request, Model model) {
		
		request.setAttribute("req_attr", "req_attr"); // req_attr = req_attr
		model.addAttribute("model_attr", "model_attr");
		return "redirect:/a2"; //a2.jsp�ƴ϶� a2�� ��û�ϴ� ������ ����	
}
	@RequestMapping(value="/a2") //a2�� ��û
	public String a2() {

		return "a3"; //a2.jsp�ƴ�	
}
}
