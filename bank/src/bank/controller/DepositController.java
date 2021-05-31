package bank.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bank.service.*;

public class DepositController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int money = Integer.parseInt(request.getParameter("money"));
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		Service s = Service.getInstance();
		int totaltMoney = s.deposit(id, money);
		
		request.setAttribute("money", money);
		request.setAttribute("tMoney", totaltMoney);
		HttpUtil.forward(request, response, "/result/depositResult.jsp");
		
	}

}
