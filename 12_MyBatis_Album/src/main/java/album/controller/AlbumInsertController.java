package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumInsertController {
    
	private final String command = "/insert.ab";
	private String getPage = "albumInsertForm";
	private String gotoPage = "redirect:/list.ab";
	
	@Autowired
	//@Qualifier("myAlbumDao")
	private AlbumDao albumDao;
	
	//albumlist에서 추가하기 클릭
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doAction() {
		
     return getPage; 
	}
	//album insertform에서 submit클릭
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("album") @Valid AlbumBean album,BindingResult result){
	
	ModelAndView mav = new ModelAndView();	
	
	if(result.hasErrors()) {
		mav.setViewName(getPage);
		return mav; 
	}
   		
    int cnt = albumDao.insertAlbum(album);   
   
    mav.setViewName(gotoPage);
    return mav; 
	}
}

//String title =request.getParameter("title"); 
//String singer =request.getParameter("singer"); 
//String price =request.getParameter("price"); 
//String day =request.getParameter("day"); 
//
//AlbumBean bean = new AlbumBean(); 
//album.setTitle(title);
//album.setSinger(singer);
//album.setPrice(price);
//album.setDay(day);
//request.setAttribute("albumBean", album);
