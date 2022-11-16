package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FContentCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		FDao dao= FDao.getInstance();
		FDto dto = dao.getFootball(num); 
		request.setAttribute("dto",dto);
	}
}
