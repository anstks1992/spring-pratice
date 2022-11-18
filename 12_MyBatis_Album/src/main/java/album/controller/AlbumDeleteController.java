package album.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import album.model.AlbumDao;

@Controller
public class AlbumDeleteController {
	private final String command = "delete.ab";
	private String gotoPage = "redirect:/list.ab";
	
	@Autowired
	private AlbumDao albumDao;
	
	@RequestMapping(command)
	public String doAction(
			@RequestParam(value="num",required = true) int num,
			@RequestParam(value="pageNumber",required = true) int pageNumber) {
		
		int cnt=albumDao.deleteAlbum(num);
		System.out.println("AlbumDeleteController cnt: "+cnt);
		return gotoPage + "?pageNumber="+pageNumber;
		//return "redirect:/list.ab?pageNumber=3"
	}

}
