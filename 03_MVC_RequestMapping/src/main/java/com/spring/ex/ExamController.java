package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExamController {

	@RequestMapping(value="elist", method = RequestMethod.GET)
	public String elist(Model model, HttpServletRequest request) {		
		model.addAttribute("name1", "유정");
		request.setAttribute("name2", "은지");
		return "exam/list";
	}
}
