package com.ptteng.fuiou.h5;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.ptteng.fuiou.utils.ConfigReader;
import com.ptteng.fuiou.utils.HttpPostUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WechatPayOrder2Servlet extends HttpServlet {
	
private static final long	serialVersionUID	= -8351498408500585300L;
	
	private static final  String APPID = ConfigReader.getString("appId");
	
	private static final String APPSECRET = ConfigReader.getString("appSecret");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	
		try
		{
			System.out.println("APPID:"+APPID +",APPSECRET:"+APPSECRET);
			//获取Code
			String code = req.getParameter("code");
			//用Code获取openId
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+APPID+"&secret="+APPSECRET+"&code="
			+code+"&grant_type=authorization_code";
			Map<String,String> params = new HashMap<String,String>();
			String respStr = HttpPostUtil.postForward(url, params);
			JSONObject json = JSONArray.parseObject(respStr);
			System.out.println("获取OpenId返回内容"+respStr);
			req.setAttribute("openid", json.getString("openid"));
			req.setAttribute("appid", APPID);
			RequestDispatcher requsetdispatcher = req
					.getRequestDispatcher("cashier_desk.jsp");
			requsetdispatcher.forward(req, resp);
		}
		catch (Exception e)
		{
			
		}
	}

}
