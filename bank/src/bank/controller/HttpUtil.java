package bank.controller;

import javax.servlet.*;
import javax.servlet.http.*;

public class HttpUtil {
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String path)
	{
		try
		{
			RequestDispatcher rd = req.getRequestDispatcher(path);
			rd.forward(req, resp);
		}catch(Exception e)
		{ 
			System.out.print("HttpUtil error" + e);
		}
	}
}
