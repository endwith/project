package com.ptteng.fuiou.query;

import com.fuiou.util.MD5;
import com.ptteng.fuiou.utils.ConfigReader;
import com.ptteng.fuiou.utils.HttpPostUtil;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * H5订单查询
 * 
 * @author xiaohao@fuiou.com
 *
 */
public class OrderQryServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -5541370946538429196L;
	
	private static final String ORDER_QRY_URL = ConfigReader.getString("h5.order_qry_url");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String orderId = req.getParameter("orderId");
		String mchntCd = req.getParameter("mchntCd");
		String mchntKey = req.getParameter("mchntKey");
		String sign = MD5.MD5Encode(new StringBuffer().append(mchntCd).append("|").append(orderId)
				.append("|").append(mchntKey).toString());
		String fm = new StringBuffer().append("<FM>").append("<MchntCd>").append(mchntCd)
				.append("</MchntCd>").append("<OrderId>").append(orderId).append("</OrderId>").append("<Sign>")
				.append(sign).append("</Sign>").append("</FM>").toString();
		Map<String, String> params = new HashMap<String,String>();
		params.put("FM", fm);
		
		try
		{
			String respStr = HttpPostUtil.postForward(ORDER_QRY_URL, params);
			System.out.println(respStr);
			String rcd = respStr.substring(respStr.indexOf("<Rcd>")+5, respStr.indexOf("</Rcd>"));
			String rDesc = respStr.substring(respStr.indexOf("<RDesc>")+7, respStr.indexOf("</RDesc>"));
			String rSign = respStr.substring(respStr.indexOf("<Sign>")+6, respStr.indexOf("</Sign>"));
			//校验签名
			resp.setContentType("text/html");
			if(rSign.equals(MD5.MD5Encode(rcd+"|"+mchntKey)))
			{
					resp.getOutputStream().write(("</br>查询结果："+rcd+"&nbsp;&nbsp;"+rDesc+"</br><a href='../index.jsp'>返回主页</a>").getBytes("utf-8"));
			}
			else
			{
				resp.getOutputStream().write("返回结果验签失败！</br><a href='../index.jsp'>返回主页</a>".getBytes("utf-8"));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			resp.getOutputStream().write("系统异常！</br><a href='../index.jsp'>返回主页</a>".getBytes("utf-8"));
		}
	}

}
