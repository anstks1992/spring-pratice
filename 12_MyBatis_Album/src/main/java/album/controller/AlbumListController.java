

package album.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;

@Controller
public class AlbumListController {

	private final String command = "/list.ab";
	private String getPage = "albumList";
	
	@Autowired
	//@Qualifier("myAlbumDao")
	private AlbumDao albumDao;
	 
	@RequestMapping(value=command)
	public ModelAndView doAction(
								@RequestParam(value="whatColumn",required = false) String whatColumn,/*  반드시 넘겨주는 것을 주소창에 써야되는데 안쓰면 에러가 발생 한다 
                                                                                                        아무것도 안넘겨도 에러발생 안시킬려면 false를 써야한다 */
								@RequestParam(value="keyword",required = false) String keyword,
								@RequestParam(value="pageNumber",required = false) String pageNumber,
								@RequestParam(value="pageSize",required = false) String pageSize,
								HttpServletRequest request) {
							
		//String whatColumn = request.getParameter("whatColumn");
		
		System.out.println("whatColumn:" + whatColumn);
		System.out.println("keyword:" + keyword);
		System.out.println("pageNumber:" + pageNumber);
		System.out.println("pageSize:" + pageSize);
		
		Map<String, String> map = new HashMap<String,String>(); // key, value
		map.put("whatColumn", whatColumn); // whatColumn=title or singer
		map.put("keyword", "%"+keyword+"%"); // keyword=검색어(%a%,%b%)
		
		//select like ~ %b%

		int totalCount = albumDao.getTotalCount(map);
		System.out.println("전체 레코드 갯수 : " + totalCount);
		
		String url = request.getContextPath()+command;
		System.out.println("url:" + url);
		
		Paging pageInfo = new Paging(pageNumber,pageSize,totalCount,url,whatColumn,keyword);
		System.out.println("offset:" + pageInfo.getOffset());
		System.out.println("limit:" + pageInfo.getLimit());
		
		List<AlbumBean> albumList = albumDao.getAlbumList(pageInfo,map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("albumList",albumList);
		mav.addObject("totalCount",totalCount);
		mav.addObject("pageInfo",pageInfo);
		
		//request.setAttribute("albumList",albumList);
		mav.setViewName(getPage);//albumList를 가지고 getPage로 넘어간다
		return mav;
		// /WEB-INF/album/albumList.jsp
	}
}
/*
select count(*)~
prepareStatement
executeQuery~
*/

