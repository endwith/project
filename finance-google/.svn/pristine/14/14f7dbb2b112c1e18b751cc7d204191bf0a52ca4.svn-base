package com.ptteng.fuiou.query;



import com.ptteng.fuiou.query.data.OrderQryByMSsn;
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
public class OrderQryByMchntSsnServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -5541370946538429196L;

	private static final String	ORDER_QRY_URL		= ConfigReader.getString("order_qry_url_1");

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
			String version = req.getParameter("version");
			String mchntCd = req.getParameter("mchntCd");
			String mchntKey = req.getParameter("mchntKey");
			String mchntOrderId = req.getParameter("mchntOrderId");
			String rem1 = req.getParameter("rem1");
			String rem2 = req.getParameter("rem2");
			String rem3 = req.getParameter("rem3");
			OrderQryByMSsn data = new OrderQryByMSsn();
			data.setMchntCd(mchntCd);
			data.setMchntOrderId(mchntOrderId);
			data.setRem1(rem1);
			data.setRem2(rem2);
			data.setRem3(rem3);
			data.setVersion(version);
			Map<String, String> params = new HashMap<String,String>();
			params.put("FM", data.buildXml(mchntKey));
			String respStr = HttpPostUtil.postForward(ORDER_QRY_URL, params);
			resp.getWriter().write(respStr);
		}
		catch (Exception e)
		{
			resp.getWriter().write("系统异常：" + e.getMessage());
		}
	}

}
