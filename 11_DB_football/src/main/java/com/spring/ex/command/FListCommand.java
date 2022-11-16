package com.spring.ex.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.spring.ex.dao.FDao;
import com.spring.ex.dto.FDto;

public class FListCommand implements FCommand {

	@Override
	public void execute(HttpServletRequest request) {
		FDao fdao = FDao.getInstance();
		ArrayList<FDto> list = fdao.getAllData();
		request.setAttribute("list", list);
	}

}
