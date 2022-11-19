package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelInsertController {

	private final String command = "/insert.tv";
	private String getPage = "travelInsertForm";
	private String gotoPage = "redirect:/list.tv";//get
	
	@Autowired
	private TravelDao travelDao;
	
	//travellist에서 추가하기 클릭
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction() {
		
     return getPage; 
	}
	
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("travel") @Valid TravelBean travel,BindingResult result) {
		
		ModelAndView mav = new ModelAndView();	
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav; 
		}
	   		
	    int cnt = travelDao.insertTravel(travel);   
	   
	    mav.setViewName(gotoPage);
	    return mav; 
		}	
		
	}

// .tv 요청을 하면 제일먼저 DispatcherServlet이 받는다 
// DispatcherServlet은 요청을 받으면 지정된 Controller로 보내고 
// Controller에서 리턴되는 값을 받아서 지정된 jsp로 보낸다

