package bank.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import bank.service.*;

public class WithdrawalController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int money = Integer.parseInt(request.getParameter("money"));
		
		String id = (String)(request.getSession().getAttribute("id"));
		
		int tMoney = Service.getInstance().withdrawal(id, money);
		if(tMoney < 0)
		{
			request.setAttribute("result", "Money is not enough");
		}
		request.setAttribute("money", money);
		request.setAttribute("tMoney", tMoney);
		HttpUtil.forward(request, response, "/result/withdrawalResult.jsp");
	}

}
