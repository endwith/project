package com.ptteng.fuiou.v15;


import com.fuiou.util.MD5;
import com.ptteng.Constants;
import com.ptteng.fuiou.utils.HttpFormUtil;
import com.ptteng.fuiou.utils.HttpPostUtil;
import com.ptteng.fuiou.utils.XmlBeanUtils;
import com.ptteng.fuiou.v15.data.CreateOrderReqData;
import com.ptteng.fuiou.v15.data.CreateOrderRespData;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付接口V1.5。注意：新接入商户请用2.0的接口
 * 
 * @author XiaoHao
 *
 */
public class OrderPayServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -495468075280598461L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String response = "";
		try
		{
			String amt = req.getParameter("amt");
			String rmk1 = req.getParameter("rmk1");
			String rmk2 = req.getParameter("rmk2");
			String rmk3 = req.getParameter("rmk3");
			String ono = req.getParameter("ono");
			String name = req.getParameter("name");
			String sfz = req.getParameter("sfz");
			CreateOrderReqData co = new CreateOrderReqData();
			co.setAmt(amt);
			co.setRmk1(rmk1);
			co.setRmk2(rmk2);
			co.setRmk3(rmk3);
			Map <String, String> params = new HashMap <String, String>();
			params.put("FM", co.buildReqXml());
			String respStr = HttpPostUtil.postForward(Constants.CREATE_ORDER_REQ_URL_V15, params);
			System.out.println(respStr);
			CreateOrderRespData cop = XmlBeanUtils.convertXml2Bean(respStr, CreateOrderRespData.class);
			cop.verifySign();
			if (!"0000".equals(cop.getRcd()))
			{
				response = cop.getrDesc();
			}
			Map <String, String> payData = new HashMap <String, String>();
			payData.put("mchntCd", Constants.H5_MCHNT_CD);
			payData.put("orderid", cop.getOrderId());
			payData.put("ono", ono);
			payData.put("backurl", Constants.PAY_BACKURL_V15);
			payData.put("reurl", Constants.PAY_REURL_V15);
			payData.put("homeurl", Constants.PAY_HOMEURL_V15);
			payData.put("name", name);
			payData.put("sfz", sfz);
			StringBuffer s = new StringBuffer();
			s.append(Constants.H5_MCHNT_CD).append("|").append(cop.getOrderId()).append("|").append(name).append("|")
					.append(ono).append("|").append(sfz).append("|").append(Constants.H5_MCHNT_KEY);
			payData.put("md5", MD5.MD5Encode(s.toString()));
			response = HttpFormUtil.formForward(Constants.PAY_ORDER_REQ_URL_V15, payData, "UTF-8");
		}
		catch (Exception e)
		{
			response = e.getMessage();
		}
		finally
		{
			resp.getWriter().write(response);
		}
	}
}
