package com.ptteng.fuiou.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 
 * @author XiaoHao
 *
 */
public class MainServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -3121683102612013114L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("微信验证>>>>>>>>>>>>>>>>>>>>>>>>>>开始");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String echostr = req.getParameter("echostr");
		System.out.println(echostr);
		resp.getOutputStream().write(echostr.getBytes());
		System.out.println("微信验证>>>>>>>>>>>>>>>>>>>>>>>>>>结束");
	}
}	
