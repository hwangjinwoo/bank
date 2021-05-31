package bank.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bank.service.*;

public class LoginController implements Controller{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			Service s = Service.getInstance();
			boolean result = s.login(id, pwd);
			String path = null;
			if(result)
			{
				HttpSession session = request.getSession();
				session.setAttribute("id", id);
				path = "/menu.jsp";
			}
			else 
			{
				path = "/index.jsp";
			}
			HttpUtil.forward(request, response, path);
		}
		
	}

}
