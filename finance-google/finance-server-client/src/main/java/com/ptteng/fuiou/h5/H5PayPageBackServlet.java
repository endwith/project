package com.ptteng.fuiou.h5;



import com.ptteng.fuiou.h5.bean.H5PayResult;
import com.ptteng.fuiou.utils.XmlBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class H5PayPageBackServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -2700657686775455677L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		try{
			InputStream in = req.getInputStream();
			byte[] buffer = new byte[req.getContentLength()];
			in.read(buffer);
			String respStr = new String(buffer,"UTF-8");
			System.out.println("前台通知内容："+respStr);
			H5PayResult payResult = XmlBeanUtils.convertXml2Bean(respStr, H5PayResult.class);
			resp.getOutputStream().write(buffer);
		}catch(Exception e){
			resp.getOutputStream().write(e.getMessage().getBytes("UTF-8"));
		}
	}

}
