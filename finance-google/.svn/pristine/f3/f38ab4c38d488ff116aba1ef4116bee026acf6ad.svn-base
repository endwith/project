package com.ptteng.fuiou.com.fuiou.h5;


import com.fuiou.mpay.encrypt.DESCoderFUIOU;
import com.fuiou.util.MD5;
import com.ptteng.fuiou.h5.bean.CashierDeskRequest;
import com.ptteng.fuiou.utils.ConfigReader;
import com.ptteng.fuiou.utils.HttpFormUtil;
import com.ptteng.fuiou.utils.XMapUtil;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CashierDeskServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String version = "1.0.0";
		String mchntcd = req.getParameter("mchntcd");
		String key = req.getParameter("key");
		String userid  = req.getParameter("userid");
		String mchntorderid = req.getParameter("mchntorderid");
		String amt = req.getParameter("amt");
		String bankcard = req.getParameter("bankcard");
		String name = req.getParameter("name");
		String idtype = req.getParameter("idtype");
		String idno = req.getParameter("idno");
		String backnotifyurl = req.getParameter("backnotifyurl");
		String pagenotifyurl = req.getParameter("pagenotifyurl");
		String payfailureurl = req.getParameter("payfailureurl");
		String tempip = req.getParameter("tempip");
		String appid =req.getParameter("appid");
		String openid =req.getParameter("openid");
		String productid =req.getParameter("productid");
		String goodsdes =req.getParameter("goodsdes");
		
		
		CashierDeskRequest bean = new CashierDeskRequest();
		bean.setVersion(version);
		bean.setMchntcd(mchntcd);
		bean.setUserid(userid);
		bean.setMchntorderid(mchntorderid);
		bean.setAmt(amt);
		bean.setBankcard(bankcard);
		bean.setName(name);
		bean.setIdno(idno);
		bean.setIdtype(idtype);
		bean.setBacknotifyurl(backnotifyurl);
		bean.setPagenotifyurl(pagenotifyurl);
		bean.setPayfailureurl(payfailureurl);
		bean.setTempip(tempip);
		bean.setAppid(appid);
		bean.setOpenid(openid);
		bean.setProductid(productid);
		bean.setGoodname(goodsdes);
		
		String sign = MD5.MD5Encode(bean.getSignStr(key), "UTF-8");
		bean.setSign(sign);
		
		try {
			System.out.println("收银台请求参数MCHNTCD:"+mchntcd);
			String FM =	XMapUtil.toXML(bean, "UTF-8");
			System.out.println("收银台请求参数FM:"+FM);
			FM = DESCoderFUIOU.desEncrypt(FM, DESCoderFUIOU.getKeyLength8(key));
			Map<String,String> param = new HashMap<String, String>();
			param.put("MCHNTCD", mchntcd);
			param.put("FM",FM);
			String url = ConfigReader.getString("h5_cashier_desk_url");
			String htmlstr = HttpFormUtil.formForward(url, param);
			resp.getOutputStream().write(htmlstr.getBytes("utf8"));
		} catch (Exception e) {
			e.printStackTrace();
			resp.getOutputStream().write("系统异常".getBytes("utf8"));
		}
		
	}
	
	

}
