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
@Controller //��û�� �������� ���� �ؿ� Ŭ������ �����ϵ��� �ϴ� ��Ʈ�ѷ� , �ݵ�� �־�� �� 
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//get������� /��û�ϸ�(=ȣ��) �˾Ƽ� home�̶�� �޼ҵ尡 ��û�ȴ�
	
	// �帧 : 
	// ������Ʈ���� run�ϸ� ���� �𸣰� /�� ��û�Ѵ�  -> web.xml -> /��û�Ҷ� �Ұ� ������ �����Ѱ�(ex servlet-context.xml)���� ���� 
	//-> �������� ��Ű���� �Ⱦ����(��û�� �־������� �� ��û�� ó���� ��Ű������ �˱����� ) -> �� ��Ű���� ��û�� ó���� Ŭ�����ΰ�(ex HomeController)
	//-> �� Ŭ�������� ������ ���� ������ �ű�� ����(ex home.jsp) -> ���� 
	
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
	//view��� ��û�� �ϴϱ� return�� ������ ��(/WEB-INF/views/member/memberview.jsp)�� ȣ���� �Ǿ ����� ��
	//���ּ�â /�ڿ� view��� ������� ��û�� �ȴ�
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request) {
		model.addAttribute("id", "kim");
		request.setAttribute("pw", "1234");
		System.out.println("list()");
		return "member/list";
	}
	
}
