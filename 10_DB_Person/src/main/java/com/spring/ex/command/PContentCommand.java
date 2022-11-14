package com.spring.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.PersonDao;
import com.spring.ex.dto.PersonDto;

public class PContentCommand  implements PCommand {
 

public void execute(HttpServletRequest request) {
	
	 int num = Integer.parseInt(request.getParameter("num"));
	    
     PersonDao pdao = PersonDao.getInstance();  
     PersonDto pdto = pdao.contentView(num); 
     
     request.setAttribute("pdto",pdto);

	
}
}
