package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
	
	@RequestMapping(value="form") 
	public String form() {			       
		return "person\\form";	
}
	
	
	//person/join1?name=kim&age=20
	@RequestMapping(value="person/join1", method = RequestMethod.GET) 
	public String personjoin(Model model, HttpServletRequest request) {	//consoleâ�� ��½� request���	
		
        String name =request.getParameter("name");  //request ��ü�� �����ϱ� ������ param�� ��µ�
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("name:" + name);
        System.out.println("age:" + age);	
        
        request.setAttribute("name2", name+"��~"); //�Ӽ����� �Ѿ���� ������ ������ �ȵǾ param����� �ȵ�
        
		return "person/result1";	
}
	
	//person/join2?id=kim&pw=1234&name=wendy&addr=seoul
	@RequestMapping(value="person/join2", method = RequestMethod.GET) 
	public String personjoin2(HttpServletRequest request) {	
		String id =request.getParameter("id");
		String pw =request.getParameter("pw");
		String name =request.getParameter("name");
		String addr =request.getParameter("addr");
		
		PersonBean pb = new PersonBean();
		pb.setId(id);
		pb.setPw(pw);
		pb.setName(name);
		pb.setAddr(addr);
		request.setAttribute("pb", pb);
		return "person/result2";	
	
}
	
	//person/join3?id=kim&pw=1234&name=wendy&addr=seoul
		@RequestMapping(value="person/join3", method = RequestMethod.GET) 
		public String personjoin3(@RequestParam("id") String id, 
				                  @RequestParam("pw") String pw,
				                  @RequestParam("name") String name,
				                  @RequestParam("addr") String addr,
				                  HttpServletRequest request) {	
//			String id =request.getParameter("id");
//			String pw =request.getParameter("pw");
//			String name =request.getParameter("name");
//			String addr =request.getParameter("addr");
			
//		@RequestParam�̶� request.getParameter�� ���� ���	
			
			PersonBean pb = new PersonBean();
			pb.setId(id);
			pb.setPw(pw);
			pb.setName(name);
			pb.setAddr(addr);
			request.setAttribute("pb", pb);
			return "person/result3";	
		
	}
		
		@RequestMapping(value="person/join4") //�޼ҵ带 �����ϸ� get,post ��� ����
		public String join4(PersonBean pb ) {	
			
			System.out.println(pb.getId()); //���⼭�� pb
			//request.setAttribute("personBean", pb);
			return "person/result4";	
			
			//command ��ü(PersonBean pb) : 
			//��û������ �����ϰ� �ִ� ��ü 
			//jps�� form���� �Ѿ�� �Ķ���͵��� ����            
	}
		
		@RequestMapping(value="person/join5") 
		public String join5(@ModelAttribute("per") PersonBean pb ) {	
		//��Ī����
			System.out.println(pb.getId());
			return "person/result5";	
			
		           
	}
}
