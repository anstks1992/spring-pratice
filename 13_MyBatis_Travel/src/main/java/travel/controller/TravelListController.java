package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelListController {

	
	private final String command = "/list.tv";
	private String getPage = "travelList";
	
	@Autowired
	private TravelDao travelDao;
	 
	@RequestMapping(value=command)
	public ModelAndView doAction(
	     @RequestParam(value="whatColumn",required = false) String whatColumn,
         @RequestParam(value="keyword",required = false) String keyword,
         @RequestParam(value="pageNumber",required = false) String pageNumber,
		 HttpServletRequest request) {
		
        Map<String, String> map = new HashMap<String, String>();//검색
        
        map.put("whatColumn", whatColumn );  //whatcolum = area or style  
        map.put("keyword", "%"+keyword+"%"); //keyword = %유%
	
		int totalCount = travelDao.getTotalCount(map); // 초기 리스트
		
		String url = request.getContextPath() + command;
		Paging pageInfo = new Paging(pageNumber,null,totalCount,url,whatColumn,keyword);
		
		ModelAndView mav = new ModelAndView(); //jsp로 무언가를 가지고 넘어갈때 하는 설절
		
		List<TravelBean> travelLists = travelDao.getTravelList(pageInfo, map);
		mav.addObject("travelLists",travelLists);
		mav.addObject("totalCount",totalCount);
		mav.addObject("pageInfo",pageInfo);
		mav.setViewName(getPage);
		//request.setAttribute("travelList",travelList);
		return mav;
		
	}
}
