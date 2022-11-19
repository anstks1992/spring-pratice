package travel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;


//TravelDao myTravleDao=new TravleDao()
@Component("myTravelDao")
public class TravelDao {

	private String namespace =  "travel.TravelBean";
	
	@Autowired //root Context.xml에서 만들어진 객체를 가져와서 넣어라
	private SqlSessionTemplate sqlSessionTemplate;
	
	public int getTotalCount(Map<String, String> map) {
		int count = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		return count;
	}
	
	public List<TravelBean> getTravelList(Paging pageInfo, Map<String, String> map){
		List<TravelBean> lists = new ArrayList<TravelBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		// 내가 검색한 페이지의 해당 페이지를 표시하기 위한 설정(ex 수를 검색시 수가 포함된 페이지만 보이게하기)
		lists = sqlSessionTemplate.selectList(namespace+".GetTravelList",map,rowBounds);
		return lists;
	}

	public int insertTravel(TravelBean travel) {
		 int cnt = sqlSessionTemplate.insert(namespace+".InsertTravel",travel);
	     return cnt;
	
	}
	
	public TravelBean getTravel(int num) {//상세보기,수정form
		TravelBean bean = sqlSessionTemplate.selectOne(namespace+".GetTravel",num);
		return bean;
	}
	
	 public int updateTravel(TravelBean travel) {		 
		    int cnt = sqlSessionTemplate.update(namespace+".UpdateTravel",travel);
			return cnt;
		}

	 public int deleteTravel(int num) {		
	        int cnt = sqlSessionTemplate.delete(namespace+".DeleteTravel",num);
	        return cnt;
	}
}
