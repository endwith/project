package com.ptteng.fuiou.h5;


import com.fuiou.util.MD5;
import com.ptteng.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WechatBackRecServlet extends HttpServlet
{
	private static final long	serialVersionUID	= -304523156153780273L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String responsecode = req.getParameter("RESPONSECODE");
		String responsemsg = req.getParameter("RESPONSEMSG");
		String mchntcd = req.getParameter("MCHNTCD");
		String mchntorderid = req.getParameter("MCHNTORDERID");
		String orderid = req.getParameter("ORDERID");
		String amt = req.getParameter("AMT");
		String sign = req.getParameter("SIGN");
		StringBuffer plain = new StringBuffer();
		plain.append(responsecode).append("|").append(mchntcd).append("|").append(mchntorderid).append("|")
				.append(orderid).append("|").append(amt).append("|").append(Constants.H5_MCHNT_KEY);
		System.out.println("接收结果签名明文："+plain.toString());
		if(MD5.MD5Encode(plain.toString()).equals(sign)){
			System.out.println("支付结果："+responsecode+"|"+responsemsg);
		}
		else
		{
			System.out.println("商户号验证签名失败~");
		}
	}

}
