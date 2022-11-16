package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.FDao;

public class FDeleteCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		FDao dao = FDao.getInstance();
		dao.delete(num);

	}
}
