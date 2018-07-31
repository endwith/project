package com.ptteng.fuiou.v15.data;

import com.fuiou.util.MD5;
import com.ptteng.Constants;
import com.ptteng.fuiou.utils.XmlBeanUtils;


import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="FM")
public class CreateOrderReqData
{
	private String mchntCd = Constants.H5_MCHNT_CD;
	private String amt;
	private String rmk1;
	private String rmk2;
	private String rmk3;
	private String sign;
	
	public String getMchntCd()
	{
		return mchntCd;
	}
	@XmlElement(name="MchntCd")
	public void setMchntCd(String mchntCd)
	{
		this.mchntCd = mchntCd;
	}
	public String getAmt()
	{
		return amt;
	}
	@XmlElement(name="Amt")
	public void setAmt(String amt)
	{
		this.amt = amt;
	}
	public String getRmk1()
	{
		return rmk1;
	}
	@XmlElement(name="Rmk1")
	public void setRmk1(String rmk1)
	{
		this.rmk1 = rmk1;
	}
	public String getRmk2()
	{
		return rmk2;
	}
	@XmlElement(name="Rmk2")
	public void setRmk2(String rmk2)
	{
		this.rmk2 = rmk2;
	}
	public String getRmk3()
	{
		return rmk3;
	}
	@XmlElement(name="Rmk3")
	public void setRmk3(String rmk3)
	{
		this.rmk3 = rmk3;
	}
	public String getSign()
	{
		return sign;
	}
	@XmlElement(name="Sign")
	public void setSign(String sign)
	{
		this.sign = sign;
	}
	
	public String buildReqXml() throws JAXBException{
		StringBuffer s = new StringBuffer();
		s.append(this.mchntCd).append("|").append(this.amt).append("|").append(Constants.H5_MCHNT_KEY);
		System.out.println("下单请求明文："+s);
		this.sign = MD5.MD5Encode(s.toString());
		return XmlBeanUtils.convertBean2Xml(this, "UTF-8", false);
	}
}
