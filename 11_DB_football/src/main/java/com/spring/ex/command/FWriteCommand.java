package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FWriteCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String win = request.getParameter("win");;
		String[] round16Arr = request.getParameterValues("round16");
		String round16 = "";
		for(int i=0;i<round16Arr.length;i++) {
			round16 += round16Arr[i]+" ";
		}
		
		FDto fdto = new FDto(0,id, pw, win, round16);

		FDao dao=FDao.getInstance();
		
		dao.write(fdto); 
	}

}
