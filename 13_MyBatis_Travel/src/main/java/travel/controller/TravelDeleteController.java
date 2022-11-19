package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelDao;

@Controller
public class TravelDeleteController {

	private final String command = "delete.tv";
	private String gotoPage = "redirect:/list.tv";
	
	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping(command)
	public String doAction(
			@RequestParam(value="num",required = true) int num,
			@RequestParam(value="pageNumber",required = true) int pageNumber) {
		
		int cnt = travelDao.deleteTravel(num);
		return gotoPage + "?pageNumber="+pageNumber;

	}
}
