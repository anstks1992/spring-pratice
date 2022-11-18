

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
								@RequestParam(value="whatColumn",required = false) String whatColumn,/*  �ݵ�� �Ѱ��ִ� ���� �ּ�â�� ��ߵǴµ� �Ⱦ��� ������ �߻� �Ѵ� 
                                                                                                        �ƹ��͵� �ȳѰܵ� �����߻� �Ƚ�ų���� false�� ����Ѵ� */
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
		map.put("keyword", "%"+keyword+"%"); // keyword=�˻���(%a%,%b%)
		
		//select like ~ %b%

		int totalCount = albumDao.getTotalCount(map);
		System.out.println("��ü ���ڵ� ���� : " + totalCount);
		
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
		mav.setViewName(getPage);//albumList�� ������ getPage�� �Ѿ��
		return mav;
		// /WEB-INF/album/albumList.jsp
	}
}
/*
select count(*)~
prepareStatement
executeQuery~
*/

