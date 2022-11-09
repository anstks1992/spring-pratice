package com.spring.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller //요청이 들어왓을때 마로 밑에 클래스가 실행하도록 하는 컨트롤러 , 반드시 있어야 함 
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//get방식으로 /요청하면(=호출) 알아서 home이라는 메소드가 요청된다
	
	// 흐름 : 
	// 프로젝트에서 run하면 나도 모르게 /를 요청한다  -> web.xml -> /요청할때 할게 있으면 지정한곳(ex servlet-context.xml)으로 가라 
	//-> 내가만든 패키지를 훑어봐라(요청이 주어졌을때 그 요청을 처리할 패키지인지 알기위해 ) -> 그 패키지에 요청을 처리한 클래스로감(ex HomeController)
	//-> 그 클래스에서 지정한 곳이 있으면 거기로 가라(ex home.jsp) -> 실행 
	
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		//request.setAttribute("serverTime", formattedDate );
		
		return "home";
		// /WEB-INF/views/home.jsp
	}
	
	@RequestMapping(value="view", method = RequestMethod.GET)
	public String view() {
		System.out.println("view()");
		return "member/memberView";
	}
	//view라고 요청을 하니까 return에 지정한 곳(/WEB-INF/views/member/memberview.jsp)이 호출이 되어서 출력이 됨
	//웹주소창 /뒤에 view라고 써줘야지 요청이 된다
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request) {
		model.addAttribute("id", "kim");
		request.setAttribute("pw", "1234");
		System.out.println("list()");
		return "member/list";
	}
	
}
