package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {

	
	private final String command="update.tv";
	private final String getPage="travelUpdateForm";
	private final String gotoPage="redirect:/list.tv";


	@Autowired
	private TravelDao travelDao;

	//travellist.jsp에서 수정클릭(get방식) -> travelUpdateForm.jsp로 이동 
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction(
			@RequestParam(value="num",required=true) int num,
			@RequestParam(value="pageNumber",required=true) int pageNumber,
			Model model) {

		TravelBean travel = travelDao.getTravel(num);

		model.addAttribute("travel", travel);
		model.addAttribute("pageNumber", pageNumber);

		return getPage;

	}//doAction
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam(value="pageNumber",required=true) int pageNumber,
			@ModelAttribute("travel") @Valid TravelBean travel, BindingResult result) {

		ModelAndView mav = new ModelAndView();

		if(result.hasErrors()) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(getPage);
			return mav; 
		}
		
		int cnt = travelDao.updateTravel(travel);
		if(cnt > 0) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(gotoPage);
		}
		else {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(getPage);
			//travelUpdateForm.jsp value에 travelUpdateForm에서 작성한 내용이 나옴
		}
		return mav;

	

	}//doAction
}

