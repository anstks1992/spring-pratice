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
	
	//travellist���� �߰��ϱ� Ŭ��
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

// .tv ��û�� �ϸ� ���ϸ��� DispatcherServlet�� �޴´� 
// DispatcherServlet�� ��û�� ������ ������ Controller�� ������ 
// Controller���� ���ϵǴ� ���� �޾Ƽ� ������ jsp�� ������
