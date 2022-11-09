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
	public String personjoin(Model model, HttpServletRequest request) {	//console창의 출력시 request사용	
		
        String name =request.getParameter("name");  //request 객체로 공유하기 때문에 param이 출력됨
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("name:" + name);
        System.out.println("age:" + age);	
        
        request.setAttribute("name2", name+"씨~"); //속성으로 넘어오기 때문에 공유가 안되어서 param출력이 안됨
        
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
			
//		@RequestParam이랑 request.getParameter는 서로 비슷	
			
			PersonBean pb = new PersonBean();
			pb.setId(id);
			pb.setPw(pw);
			pb.setName(name);
			pb.setAddr(addr);
			request.setAttribute("pb", pb);
			return "person/result3";	
		
	}
		
		@RequestMapping(value="person/join4") //메소드를 생략하면 get,post 모두 가능
		public String join4(PersonBean pb ) {	
			
			System.out.println(pb.getId()); //여기서는 pb
			//request.setAttribute("personBean", pb);
			return "person/result4";	
			
			//command 객체(PersonBean pb) : 
			//요청정보를 저장하고 있는 객체 
			//jps의 form에서 넘어가는 파라미터들의 모음            
	}
		
		@RequestMapping(value="person/join5") 
		public String join5(@ModelAttribute("per") PersonBean pb ) {	
		//별칭지정
			System.out.println(pb.getId());
			return "person/result5";	
			
		           
	}
}
