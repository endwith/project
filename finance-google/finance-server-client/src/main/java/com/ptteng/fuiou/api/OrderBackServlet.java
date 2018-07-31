package com.ptteng.fuiou.api;


import com.fuiou.util.MD5;
import com.ptteng.Constants;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 下单返回消息接收(2016-09-30)
 * 
 * @author xiaohao@fuiou.com
 *
 */
public class OrderBackServlet extends HttpServlet
{
	private static final long	serialVersionUID	= 1419376384387536955L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String version = req.getParameter("VERSION");
		String type = req.getParameter("TYPE");
		String responseCode = req.getParameter("RESPONSECODE");
		String responseMsg = req.getParameter("RESPONSEMSG");
		String mchntCd = req.getParameter("MCHNTCD");
		String mchntOrderId = req.getParameter("MCHNTORDERID");
		String orderId = req.getParameter("ORDERID");
		String bankCard = req.getParameter("BANKCARD");
		String amt = req.getParameter("AMT");
		String sign = req.getParameter("SIGN");

		// 校验签名
		String signPain = new StringBuffer().append(type).append("|").append(version).append("|").append(responseCode)
				.append("|").append(mchntCd).append("|").append(mchntOrderId).append("|").append(orderId).append("|")
				.append(amt).append("|").append(bankCard).append("|").append(Constants.API_MCHNT_KEY).toString();
		resp.setContentType("text/html");
		if (MD5.MD5Encode(signPain).equals(sign))
		{
			if (Constants.RESP_CODE_SUCCESS.equals(responseCode))
			{
				
				resp.getOutputStream().write(("支付成功！富友流水号："+orderId+"</br><a href='../index.jsp'>返回主页</a>").getBytes("utf-8"));
			}
			else
			{
				resp.getOutputStream().write(("支付失败！返回码：" + responseCode + ",返回信息：" + responseMsg+"</br><a href='../index.jsp'>返回主页</a>").getBytes("utf-8"));
			}
		}
		else
		{
			resp.getOutputStream().write("返回结果验签失败！</br><a href='../index.jsp'>返回主页</a>".getBytes("utf-8"));
		}
	}
}
