package com.ptteng.fuiou.h5;


import com.fuiou.mpay.encrypt.DESCoderFUIOU;
import com.fuiou.util.MD5;
import com.ptteng.Constants;
import com.ptteng.fuiou.utils.ConfigReader;
import com.ptteng.fuiou.utils.DateTimeUtil;
import com.ptteng.fuiou.utils.HttpFormUtil;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * H5支付(2016-09-29)
 * 
 * @author xiaohao@fuiou.com
 *
 */
public class H5PayServlet extends HttpServlet
{
	private static final long	serialVersionUID	= 1419376384387536955L;

	private static final String BACK_URL = ConfigReader.getString("h5.back_url");
	private static final String HOME_URL = ConfigReader.getString("h5.home_url");
	private static final String RETURN_URL = ConfigReader.getString("h5.return_url");
	private static final String PAY_URL = ConfigReader.getString("h5.pay_url");
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.getOutputStream().write("不支持GET方式提交".getBytes("utf8"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String respMsg = "";
		resp.setContentType("text/html");
		try
		{
			String userId = req.getParameter("userId");
			String amt = req.getParameter("amt");
			String bankCard = req.getParameter("bankCard");
			String name = req.getParameter("name");
			String idType = req.getParameter("idType");
			String idNo = req.getParameter("idNo");
			String type=req.getParameter("type");
			StringBuffer orderPlain = new StringBuffer();
			String orderId = "FY"+DateTimeUtil.getCurrentDate("yyyyMMddHHmmssSSS");
			String signPlain = type+"|"+"2.0"+"|"+Constants.H5_MCHNT_CD+"|"+orderId+"|"+userId
					+"|"+amt+"|"+bankCard+"|"+BACK_URL+"|"+name+"|"+idNo+"|"+idType+"|"+"0"+"|"
					+ HOME_URL+"|"+RETURN_URL+"|"+Constants.H5_MCHNT_KEY;
			String sign=MD5.MD5Encode(signPlain);
			System.out.println("[签名明文:]"+signPlain);
			orderPlain.append("<ORDER>")
			.append("<VERSION>2.0</VERSION>")
			.append("<LOGOTP>0</LOGOTP>")
			.append("<MCHNTCD>").append(Constants.H5_MCHNT_CD).append("</MCHNTCD>")
			.append("<TYPE>").append(type).append("</TYPE>")
			.append("<MCHNTORDERID>").append(orderId).append("</MCHNTORDERID>")
			.append("<USERID>").append(userId).append("</USERID>")
			.append("<AMT>").append(amt).append("</AMT>")
			.append("<BANKCARD>").append(bankCard).append("</BANKCARD>")
			.append("<BACKURL>").append(BACK_URL).append("</BACKURL>")
			.append("<HOMEURL>").append(HOME_URL).append("</HOMEURL>")
			.append("<REURL>").append(RETURN_URL).append("</REURL>")
			.append("<NAME>").append(name).append("</NAME>")
			.append("<IDTYPE>").append(idType).append("</IDTYPE>")
			.append("<IDNO>").append(idNo).append("</IDNO>")
			.append("<REM1>").append(userId).append("</REM1>")
			.append("<REM2>").append(userId).append("</REM2>")
			.append("<REM3>").append(userId).append("</REM3>")
			.append("<SIGNTP>").append("md5").append("</SIGNTP>")
			.append("<SIGN>").append(sign).append("</SIGN>")
			.append("</ORDER>");
			System.out.println("[订单信息:]"+orderPlain.toString());
			Map<String,String> param = new HashMap<String, String>();
			param.put("VERSION", "2.0");
			param.put("ENCTP", "1");
			param.put("LOGOTP", "0");
			param.put("MCHNTCD", Constants.H5_MCHNT_CD);
			param.put("FM",orderPlain.toString());
			param.put("FM", DESCoderFUIOU.desEncrypt(orderPlain.toString(), DESCoderFUIOU.getKeyLength8(Constants.H5_MCHNT_KEY)));
			respMsg = HttpFormUtil.formForward(PAY_URL, param);
			System.out.println("[请求信息:]"+param);
		}
		catch (Exception e)
		{
			respMsg="系统异常！";
		}
		resp.getOutputStream().write(respMsg.getBytes("utf8"));
	}
}
