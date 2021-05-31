package bank.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bank.service.*;

public class SearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		
		boolean result = Service.getInstance().search(id);
		String msg=null;
		if(result == false)
			msg = "false";
		else
			msg = "true";
		request.setAttribute("msg", msg);
		request.setAttribute("rId", id);
		HttpUtil.forward(request, response, "/transfer.jsp");
	}

}
