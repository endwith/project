package com.ptteng.fuiou.v15.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="")
public class PayOrderReqData
{
	private String mchntCd;
	private String orderid;
	private String ono;
	private String backurl;
	private String reurl;
	private String homeurl;
	private String name;
	private String sfz;
	private String md5;
	
	public String getMchntCd()
	{
		return mchntCd;
	}
	public void setMchntCd(String mchntCd)
	{
		this.mchntCd = mchntCd;
	}
	public String getOrderid()
	{
		return orderid;
	}
	public void setOrderid(String orderid)
	{
		this.orderid = orderid;
	}
	public String getOno()
	{
		return ono;
	}
	public void setOno(String ono)
	{
		this.ono = ono;
	}
	public String getBackurl()
	{
		return backurl;
	}
	public void setBackurl(String backurl)
	{
		this.backurl = backurl;
	}
	public String getReurl()
	{
		return reurl;
	}
	public void setReurl(String reurl)
	{
		this.reurl = reurl;
	}
	public String getHomeurl()
	{
		return homeurl;
	}
	public void setHomeurl(String homeurl)
	{
		this.homeurl = homeurl;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSfz()
	{
		return sfz;
	}
	public void setSfz(String sfz)
	{
		this.sfz = sfz;
	}
	public String getMd5()
	{
		return md5;
	}
	public void setMd5(String md5)
	{
		this.md5 = md5;
	}
}
