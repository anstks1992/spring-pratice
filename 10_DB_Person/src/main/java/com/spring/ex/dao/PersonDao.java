package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.PersonDto;

public class PersonDao {

	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String id="jspid";
	String pw="jsppw";

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

private static PersonDao instance;
	
	private PersonDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	public static PersonDao getInstance() {
		if(instance == null) {
			instance = new PersonDao();
		}
		return instance;
	}
	
	public void write(String id, String name, String age) {
		 
		String sql = "insert into person(num,id,name,age) values(person_seq.nextval,?,?,?)";   
		
        try {      
        	ps = conn.prepareStatement(sql);
      
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, age);
 
            ps.executeUpdate();
 
        } catch (Exception e) {
            e.printStackTrace();
 
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//write
	
	public ArrayList<PersonDto> getAllPerson() {
		ArrayList<PersonDto> lists = new ArrayList<PersonDto>();
		String sql = "select * from person order by num";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				PersonDto pd = new PersonDto();
				pd.setNum(rs.getInt("num"));
				pd.setId(rs.getString("id"));
				pd.setName(rs.getString("name"));
				pd.setAge(rs.getInt("age"));
				
				lists.add(pd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lists;
	}//getAllPerson
	
	public PersonDto contentView(int num) {
	            
		PersonDto pdto =null;
        try {
            String sql = "select * from person where num =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, num);
            rs = ps.executeQuery();
 
            if (rs.next()) {
                int num2 = rs.getInt("num");
                String id = rs.getString("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
 
                pdto = new PersonDto(num, id, name, age);
 
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
 
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
 
        return pdto;
    }// contentview()
	
	public void modify(String num, String name, String age) {
		int cnt = -1;

		String sql = "update person set name=?,age=? where num=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,age);
			ps.setString(3,num);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	 
	 public void delete(String num){
	                        
		 String sql = "delete from person where num=?";
	        try {
	           
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, num);
	 
	            ps.executeUpdate();
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (ps != null) {
	                    ps.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	 
	    }// delete
	 
	}
	
