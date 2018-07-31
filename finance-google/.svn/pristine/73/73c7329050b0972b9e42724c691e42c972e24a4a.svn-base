package com.ptteng.fuiou.h5.bean;

import org.nuxeo.common.xmap.annotation.XNode;
import org.nuxeo.common.xmap.annotation.XObject;

@XObject(value = "FM")
public class CashierDeskRequest {
	@XNode("VERSION")
	private String version;
	@XNode("USERID")
	private String userid;
	@XNode("MCHNTORDERID")
	private String mchntorderid;
	@XNode("AMT")
	private String amt;
	@XNode("NAME")
	private String name;
	@XNode("IDTYPE")
	private String idtype;
	@XNode("IDNO")
	private String idno;
	@XNode("BANKCARD")
	private String bankcard;
	@XNode("PRODUCTID")
	private String productid;
	@XNode("GOODSDES")
	private String goodsdes;
	@XNode("GOODNAME")
	private String goodname;
	@XNode("OPENID")
	private String openid;
	@XNode("APPID")
	private String appid;
	@XNode("TEMPIP")
	private String tempip;
	@XNode("BACKNOTIFYURL")
	private String backnotifyurl;
	@XNode("PAGENOTIFYURL")
	private String pagenotifyurl;
	@XNode("PAYFAILUREURL")
	private String payfailureurl;
	@XNode("REM1")
	private String rem1;
	@XNode("REM2")
	private String rem2;
	@XNode("REM3")
	private String rem3;
	@XNode("SIGN")
	private String sign;//签名
	// 富友分配给各合作商户的唯一识别码
	@XNode("MCHNTCD")
	private String	mchntcd	 = "";
	
	public String getRem1() {
		return rem1;
	}
	public void setRem1(String rem1) {
		this.rem1 = rem1;
	}
	public String getRem2() {
		return rem2;
	}
	public void setRem2(String rem2) {
		this.rem2 = rem2;
	}
	public String getRem3() {
		return rem3;
	}
	public void setRem3(String rem3) {
		this.rem3 = rem3;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getMchntorderid() {
		return mchntorderid;
	}
	public void setMchntorderid(String mchntorderid) {
		this.mchntorderid = mchntorderid;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdtype() {
		return idtype;
	}
	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}
	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
	}
	public String getBankcard() {
		return bankcard;
	}
	public void setBankcard(String bankcard) {
		this.bankcard = bankcard;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getGoodsdes() {
		return goodsdes;
	}
	public void setGoodsdes(String goodsdes) {
		this.goodsdes = goodsdes;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getBacknotifyurl() {
		return backnotifyurl;
	}
	public void setBacknotifyurl(String backnotifyurl) {
		this.backnotifyurl = backnotifyurl;
	}
	public String getPagenotifyurl() {
		return pagenotifyurl;
	}
	public void setPagenotifyurl(String pagenotifyurl) {
		this.pagenotifyurl = pagenotifyurl;
	}
	public String getPayfailureurl() {
		return payfailureurl;
	}
	public void setPayfailureurl(String payfailureurl) {
		this.payfailureurl = payfailureurl;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getMchntcd() {
		return mchntcd;
	}
	public void setMchntcd(String mchntcd) {
		this.mchntcd = mchntcd;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public String getTempip() {
		return tempip;
	}
	public void setTempip(String tempip) {
		this.tempip = tempip;
	}
	//获取签名串
	public String getSignStr(String key){
		StringBuilder sb = new StringBuilder();
		sb.append(version);
		sb.append("|");
		sb.append(mchntcd);
		sb.append("|");
		sb.append(userid);
		sb.append("|");
		sb.append(mchntorderid);
		sb.append("|");
		sb.append(amt);
		sb.append("|");
		sb.append(backnotifyurl);
		sb.append("|");
		sb.append(key);
		return sb.toString();
	}
	
	

}
