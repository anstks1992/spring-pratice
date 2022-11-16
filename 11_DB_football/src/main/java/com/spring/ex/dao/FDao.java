package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.FDto;

public class FDao {
	String driver="oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";

	private static FDao instance;
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	private FDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("드라이버 로드 성공");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}// 생성자

	public static FDao getInstance() {
		if(instance == null) {
			instance = new FDao();
		}
		return instance;
	}//

	public void write(FDto fdto) {

		String sql = "insert into football values(fb_seq.nextval,?,?,?,?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,fdto.getId());
			ps.setString(2,fdto.getPw());
			ps.setString(3,fdto.getWin());
			ps.setString(4,fdto.getRound16());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}//write

	public ArrayList<FDto> getAllData(){
		ArrayList<FDto> lists=new ArrayList<FDto>();
		String sql="select * from football order by num";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				FDto dto=new FDto();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setWin(rs.getString("win"));
				dto.setRound16(rs.getString("round16"));
				lists.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					rs.close();					
				}
				if(ps!=null) {
					ps.close();					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("list갯수:"+lists.size());
		return lists;
	}//list

	public FDto getFootball(String num){
		FDto dto=null;
		String sql="select * from football where num=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, num);
			rs=ps.executeQuery();
			if(rs.next()) {
				dto = new FDto();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setWin(rs.getString("win"));
				dto.setRound16(rs.getString("round16"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				} 
				if(ps != null) {
					ps.close();
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}//getFootball

	public void modify(String num, String pw, String win, String round16) {
		String sql = "update football set pw=?, win=?, round16=? where num=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pw);
			ps.setString(2, win);
			ps.setString(3, round16);
			ps.setString(4, num);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("modify 분석 오류");
		} finally {
			try {
				if(ps!=null)
					ps.close();
			}catch(SQLException e) {
				System.out.println("modify close 오류");
			}
		}
		
	}//modify

	public void delete(String num) {
		String sql = "delete football where num=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, num);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//delete
}
	

