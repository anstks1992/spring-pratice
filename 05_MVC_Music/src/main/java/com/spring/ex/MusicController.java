package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MusicController {

	@RequestMapping(value="form") 
	public String form() {			       
		return "music/form";	
}

	//input1(){
	//}
	//music/result1.jsp로 이동해서 입력한 항목 모두 출력
	
	@RequestMapping(value="input1") 
	public String input1() {			       
		
		return "music/result1";	
}
	//input2(){
	// request.getParameter()
	// MusicBean객체로 만들기 
	//}
    //music/result2.jsp로 이동해서 입력한 항목 모두 출력
	
	@RequestMapping(value="input2") 
	public String input2(HttpServletRequest request) {	
		
        String title =request.getParameter("title"); 
        String singer =request.getParameter("singer"); 
        String price =request.getParameter("price"); 
        
        MusicBean mb = new MusicBean(); 
		mb.setTitle(title);
		mb.setSinger(singer);
		mb.setPrice(price);
		request.setAttribute("mb", mb);
         
		return "music/result2";	
}
	//input3(@){
	// request.getParameter()
	// MusicBean객체로 만들기 
	//}
	//music/result3.jsp로 이동해서 입력한 항목 모두 출력
	
	@RequestMapping(value="input3") 
	public String input3(@RequestParam("title") String title, 
			             @RequestParam("singer") String singer,
			             @RequestParam("price") String price,
			                  HttpServletRequest request) {	
		
		MusicBean mb = new MusicBean(); 
		mb.setTitle(title);
		mb.setSinger(singer);
		mb.setPrice(price);
		request.setAttribute("mb", mb);
		return "music/result3";	
}
	//input4(command 객체){
	// request.getParameter()
	// MusicBean객체로 만들기 
	//}
	//music/result4.jsp로 이동해서 입력한 항목 모두 출력

	@RequestMapping(value="input4") 
	public String input4(MusicBean mb ) {			
		return "music/result4";	
		      
}
	//input5(command 객체 별칭){
	// request.getParameter()
	// MusicBean객체로 만들기 
	//}
	//music/result5.jsp로 이동해서 입력한 항목 모두 출력

	
	@RequestMapping(value="input5") 
	public String input5(@ModelAttribute("inp") MusicBean mb ) {	
		return "music/result5";			
	           
}
	@RequestMapping(value="input6")
	public ModelAndView input6(HttpServletRequest request) {
		
		String title = request.getParameter("title");
		String singer = request.getParameter("singer");
		String price = request.getParameter("price");
		
		MusicBean mb = new MusicBean();
		mb.setTitle(title);
		mb.setSinger(singer);
		mb.setPrice(price);
		//request.setAttribute("mb", mb);
		
		ModelAndView mav = new ModelAndView(); // 
		mav.addObject("mb", mb);
		mav.setViewName("music/result6");
		
		return mav;
		
        //ModelAndView mav = new ModelAndView("music/result6");
        //return mav;
		//return "music/result6";
	}

	}
	
	

	

