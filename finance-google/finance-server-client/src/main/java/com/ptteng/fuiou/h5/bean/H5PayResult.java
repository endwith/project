package com.ptteng.fuiou.h5.bean;

import javax.xml.bind.annotation.XmlElement;

public class H5PayResult
{
	private String version;
	
	private String responsecode;
	
	private String responsemsg;
	
	private String mchntorderid;
	
	private String orderid;
	
	private String amt;
	
	private String bankcard;
	
	private String rem1;
	
	private String rem2;
	
	private String rem3;
	
	private String signtp;
	
	private String mchntcd;
	
	private String sign;
	
	private String type;
	
	private String userid;

	public String getVersion()
	{
		return version;
	}

	@XmlElement(name="VERSION")
	public void setVersion(String version)
	{
		this.version = version;
	}

	public String getResponsecode()
	{
		return responsecode;
	}
	@XmlElement(name="RESPONSECODE")
	public void setResponsecode(String responsecode)
	{
		this.responsecode = responsecode;
	}

	public String getResponsemsg()
	{
		return responsemsg;
	}
	@XmlElement(name="RESPONSEMSG")
	public void setResponsemsg(String responsemsg)
	{
		this.responsemsg = responsemsg;
	}

	public String getMchntorderid()
	{
		return mchntorderid;
	}
	@XmlElement(name="MCHNTORDERID")
	public void setMchntorderid(String mchntorderid)
	{
		this.mchntorderid = mchntorderid;
	}

	public String getOrderid()
	{
		return orderid;
	}
	@XmlElement(name="ORDERID")
	public void setOrderid(String orderid)
	{
		this.orderid = orderid;
	}

	public String getAmt()
	{
		return amt;
	}
	@XmlElement(name="AMT")
	public void setAmt(String amt)
	{
		this.amt = amt;
	}

	public String getBankcard()
	{
		return bankcard;
	}
	@XmlElement(name="BANKCARD")
	public void setBankcard(String bankcard)
	{
		this.bankcard = bankcard;
	}

	public String getRem1()
	{
		return rem1;
	}
	@XmlElement(name="REM1")
	public void setRem1(String rem1)
	{
		this.rem1 = rem1;
	}

	public String getRem2()
	{
		return rem2;
	}
	@XmlElement(name="REM2")
	public void setRem2(String rem2)
	{
		this.rem2 = rem2;
	}

	public String getRem3()
	{
		return rem3;
	}
	@XmlElement(name="REM3")
	public void setRem3(String rem3)
	{
		this.rem3 = rem3;
	}

	public String getSigntp()
	{
		return signtp;
	}
	@XmlElement(name="SIGNTP")
	public void setSigntp(String signtp)
	{
		this.signtp = signtp;
	}

	public String getMchntcd()
	{
		return mchntcd;
	}
	@XmlElement(name="MCHNTCD")
	public void setMchntcd(String mchntcd)
	{
		this.mchntcd = mchntcd;
	}

	public String getSign()
	{
		return sign;
	}
	@XmlElement(name="SIGN")
	public void setSign(String sign)
	{
		this.sign = sign;
	}

	public String getType()
	{
		return type;
	}
	@XmlElement(name="TYPE")
	public void setType(String type)
	{
		this.type = type;
	}

	public String getUserid()
	{
		return userid;
	}
	@XmlElement(name="USERID")
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	
}
