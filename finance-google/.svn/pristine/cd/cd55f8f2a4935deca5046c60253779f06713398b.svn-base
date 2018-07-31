package com.ptteng.fuiou.v15;


import com.fuiou.util.MD5;
import com.ptteng.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PayCallBackServelet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1393025363655559062L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String rcd = req.getParameter("rcd");
		String rdesc = req.getParameter("rdesc");
		String orderid = req.getParameter("orderid");
		String ono = req.getParameter("ono");
		String amt = req.getParameter("amt");
		String md5 = req.getParameter("md5");
		StringBuffer s = new StringBuffer();
		s.append(rcd).append("|").append(orderid).append("|").append(Constants.H5_MCHNT_KEY);
		if (md5.equals(MD5.MD5Encode(s.toString())))
		{
			resp.getWriter().write("支付结果>>>>>" + rcd + ":" + rdesc);
		}
		else
		{
			resp.getWriter().write("验签失败~");
		}
	}
}
