package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.FDao;

public class FUpdateCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		String pw = request.getParameter("pw");
		
		String win = request.getParameter("win");
		String[] round16Arr = request.getParameterValues("round16"); 
		String round16 = "";
		for(int i=0;i<round16Arr.length;i++) {
			round16 += round16Arr[i] + " ";
		}
		
		FDao dao = FDao.getInstance();		
		dao.modify(num,pw, win, round16);
	}

}
