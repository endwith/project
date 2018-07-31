package com.ptteng.fuiou.query;


import com.fuiou.util.MD5;
import com.ptteng.Constants;
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
 * 限额查询
 * 
 * @author xiaohao@fuiou.com
 *
 */
public class LimitQryQryServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -5541370946538429196L;

	private static final String	LIMIT_QRY_URL		= ConfigReader.getString("h5.limit_qry_url");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String insCd = req.getParameter("insCd");
		String sign = MD5.MD5Encode(new StringBuffer().append(Constants.H5_MCHNT_CD).append("|").append(insCd)
				.append("|").append(Constants.H5_MCHNT_KEY).toString());
		String fm = new StringBuffer().append("<FM>").append("<MCHNTCD>").append(Constants.H5_MCHNT_CD)
				.append("</MCHNTCD>").append("<INSCD>").append(insCd).append("</INSCD>").append("<SIGN>").append(sign)
				.append("</SIGN>").append("</FM>").toString();
		Map <String, String> params = new HashMap <String, String>();
		params.put("FM", fm);

		try
		{
			String respStr = HttpPostUtil.postForward(LIMIT_QRY_URL, params);
			System.out.println(respStr);
			String rcd = respStr.substring(respStr.indexOf("<RESPONSECODE>") + 14, respStr.indexOf("</RESPONSECODE>"));
			String rDesc = respStr.substring(respStr.indexOf("<RESPONSEMSG>") + 13, respStr.indexOf("</RESPONSEMSG>"));
			String rSign = "";
			String amtLimitTimelow = "";
			String amtLimitTime = "";
			String mchntCd = "";
			String amtLimitDay = "";
			String amtLimitMonth = "";
			String cTp = "";
			if (Constants.RESP_CODE_SUCCESS.equals(rcd))
			{
				mchntCd = respStr.substring(respStr.indexOf("<MCHNTCD>") + 9, respStr.indexOf("</MCHNTCD>"));

				insCd = respStr.substring(respStr.indexOf("<INSCD>") + 7, respStr.indexOf("</INSCD>"));

				if (respStr.indexOf("<AMTLIMITTIME>") > -1)
				{
					amtLimitTime = respStr.substring(respStr.indexOf("<AMTLIMITTIME>") + 14,
							respStr.indexOf("</AMTLIMITTIME>"));
				}
				if (respStr.indexOf("<AMTLIMITTIMELOW>") > -1)
				{
					amtLimitTimelow = respStr.substring(respStr.indexOf("<AMTLIMITTIMELOW>") + 17,
							respStr.indexOf("</AMTLIMITTIMELOW>"));
				}
				if (respStr.indexOf("<AMTLIMITDAY>") > -1)
				{
					amtLimitDay = respStr.substring(respStr.indexOf("<AMTLIMITDAY>") + 13,
							respStr.indexOf("</AMTLIMITDAY>"));
				}
				if (respStr.indexOf("<AMTLIMITMONTH>") > -1)
				{
					amtLimitMonth = respStr.substring(respStr.indexOf("<AMTLIMITMONTH>") + 15,
							respStr.indexOf("</AMTLIMITMONTH>"));
				}
				cTp = respStr.substring(respStr.indexOf("<CARDTYPE>") + 10, respStr.indexOf("</CARDTYPE>"));
				rSign = respStr.substring(respStr.indexOf("<SIGN>") + 6, respStr.indexOf("</SIGN>"));
			}

			// 校验签名
			resp.setContentType("text/html");
			if (!Constants.RESP_CODE_SUCCESS.equals(rcd)
					|| rSign.equals(MD5.MD5Encode(mchntCd + "|" + rcd + "|" + rDesc + "|" + Constants.H5_MCHNT_KEY)))
			{
				resp.getOutputStream().write(
						("</br>>>>>>>>>>>>>>>查询结果<<<<<<<<<<<<<<<<</br>" + "响应代码：" + rcd + "</br>中文描述：" + rDesc
								+ "</br>银行机构号：" + insCd + "</br>卡类型：" + cTp + "</br>单笔限额(最高)：" + amtLimitTime
								+ "</br>单笔限额(最低)：" + amtLimitTimelow + "</br>单日限额：" + amtLimitDay + "</br>单月限额："
								+ amtLimitMonth + "</br><a href='../index.jsp'>返回主页</a>").getBytes("utf-8"));
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
