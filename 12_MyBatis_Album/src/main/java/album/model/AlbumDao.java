package album.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

//AlbumDao myAlbumDao=new AlbumDao()
@Component("myAlbumDao")
public class AlbumDao {
	
	@Autowired //root Context.xml���� ������� ��ü�� �����ͼ� �־��
	//@Qualifier("sqlSessionTemplate")
	SqlSessionTemplate sqlSessionTemplate;
	
	
	private String namespace =  "album.AlbumBean";
	
	public int getTotalCount(Map<String, String> map) {
		int cnt = -1;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		// cnt = sqlSessionTemplate.selectOne("album.AlbumBean.GetTotalCount");
		// album.xml�� �ִ� album.AlbumBean�ȿ� GetTotalCount�� �����ض�
		// album.xml���� ������ ������� ������ ������ �ͼ� AlbumListController���� ����ض�
		System.out.println("cnt:" + cnt);
		return cnt;
	}
	
	public List<AlbumBean> getAlbumList(Paging pageinfo  , Map<String, String> map){
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		RowBounds rowBounds = new RowBounds(pageinfo.getOffset(),pageinfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".GetAlbumList",map,rowBounds);
		System.out.println("lists.size():"+lists.size());
		return lists;
	}//getAlbumList()
	
	public int insertAlbum(AlbumBean album) {
		System.out.println("insertAlbum");
		int cnt = sqlSessionTemplate.insert(namespace+".InsertAlbum",album);//album.AlbumBean.InsertAlbum
		System.out.println("insertAlbum cnt : " + cnt);

		return cnt;
	}//insertAlbum()
	
	public int deleteAlbum(int num) {		
	        int cnt = sqlSessionTemplate.delete(namespace+".DeleteAlbum",num);
	        System.out.println("delete cnt : "+cnt);
	        return cnt;
	}
	
	 public AlbumBean getAlbum(int num) {	        
	        AlbumBean album = sqlSessionTemplate.selectOne(namespace+".GetAlbum",num);
	        return album;
	   }
	 
	 public int updateAlbum(AlbumBean album) {
			int cnt =-1;
		    cnt = sqlSessionTemplate.update(namespace+".UpdateAlbum",album);
			System.out.println("updateAlbum cnt : " + cnt);
			return cnt;
		}




}








