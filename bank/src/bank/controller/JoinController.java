package bank.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bank.service.*;
import bank.vo.*;

public class JoinController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id =request.getParameter("id");
		String pwd = request.getParameter("pwd");
		Account account = new Account(id, pwd);
		
		Service s = Service.getInstance();
		s.join(account);
		
		HttpUtil.forward(request, response, "/index.jsp");
	}

}
