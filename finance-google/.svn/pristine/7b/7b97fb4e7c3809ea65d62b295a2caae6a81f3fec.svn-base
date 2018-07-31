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
 * Card Bin查询
 * 
 * @author xiaohao@fuiou.com
 *
 */
public class CardBinQryServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -5541370946538429196L;

	private static final String	CARD_BIN_QRY_URL	= ConfigReader.getString("h5.card_bin_qry_url");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String cardNo = req.getParameter("cardNo");
		String sign = MD5.MD5Encode(new StringBuffer().append(Constants.H5_MCHNT_CD).append("|").append(cardNo)
				.append("|").append(Constants.H5_MCHNT_KEY).toString());
		String fm = new StringBuffer().append("<FM>").append("<MchntCd>").append(Constants.H5_MCHNT_CD)
				.append("</MchntCd>").append("<Ono>").append(cardNo).append("</Ono>").append("<Sign>").append(sign)
				.append("</Sign>").append("</FM>").toString();
		Map <String, String> params = new HashMap <String, String>();
		params.put("FM", fm);

		try
		{
			String respStr = HttpPostUtil.postForward(CARD_BIN_QRY_URL, params);
			System.out.println(respStr);
			String rcd = respStr.substring(respStr.indexOf("<Rcd>") + 5, respStr.indexOf("</Rcd>"));
			String rDesc = respStr.substring(respStr.indexOf("<RDesc>") + 7, respStr.indexOf("</RDesc>"));
			String cTp = respStr.substring(respStr.indexOf("<Ctp>") + 5, respStr.indexOf("</Ctp>"));
			String cNm = respStr.substring(respStr.indexOf("<Cnm>") + 5, respStr.indexOf("</Cnm>"));
			String insCd = respStr.substring(respStr.indexOf("<InsCd>") + 7, respStr.indexOf("</InsCd>"));
			String rSign = respStr.substring(respStr.indexOf("<Sign>") + 6, respStr.indexOf("</Sign>"));
			// 校验签名
			resp.setContentType("text/html");
			if (rSign.equals(MD5.MD5Encode(rcd + "|" + Constants.H5_MCHNT_KEY)))
			{
				resp.getOutputStream()
						.write(("</br>>>>>>>>>>>>>>>查询结果<<<<<<<<<<<<<<<<</br>" + "响应代码：" + rcd + "</br>中文描述：" + rDesc
								+ "</br>卡类型：" + cTp + "</br>银行名称：" + cNm + "</br>银行机构号：" + insCd + "</br><a href='../index.jsp'>返回主页</a>")
								.getBytes("utf-8"));
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
