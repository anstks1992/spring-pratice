package com.spring.ex.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FController {

	FCommand command;
	@RequestMapping(value="write_view")
	public String write_view() {
		return "write_view";
	}

	@RequestMapping(value="write", method=RequestMethod.POST)
	public String write(HttpServletRequest request) {
		command = new FWriteCommand();
		command.execute(request);
		return "redirect:/list";
	}

	@RequestMapping(value="list")
	public String list(HttpServletRequest request) {
		command = new FListCommand();
		command.execute(request);
		return "list";
	}
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request) {
		command=new FContentCommand();
		command.execute(request);
		String page="content_view";
		return page;
	}

	@RequestMapping(value = "modify")
	public String update(HttpServletRequest request) {
		System.out.println("modify");
		command = new FUpdateCommand();
		command.execute(request);
		String page="redirect:/list";
		return page;
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request) {
		command=new FDeleteCommand();
		command.execute(request);
		return "redirect:/list";
	}

}
