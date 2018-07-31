<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="com.fuiou.pay.client.txn.NewOrderData"%>
<%@page import="com.fuiou.pay.client.util.MD5"%>
<%@page import="com.fuiou.pay.client.util.StringUtils"%>
<%@page import="java.security.*"%>
<%@page import="sun.misc.*"%>
<%@page import="java.security.spec.*"%>
<%@ page import="com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提交到富友交易系统</title>
</head>
<script type="text/javascript">
function submitForm(){
document.getElementById("form").submit();
}
</script>
<body onload="javascript:submitForm();">
 <form name="pay" method="post" action="http://www-1.fuiou.com:8888/wg1_run/dirPayGate.do" id = "form">
  <input type="hidden" value = "${RSA}" name="RSA"/>
<input type="hidden" value = "${mchnt_cd}" name="mchnt_cd"/>
<input type="hidden" value = "${order_id}" name="order_id"/>
<input type="hidden" value = "${order_amt}" name="order_amt"/>
<input type="hidden" value = "${user_type}" name="user_type"/>
<input type="hidden" value = "${card_no}" name="card_no"/>
<input type="hidden" value = "${page_notify_url}" name="page_notify_url"/>
<input type="hidden" value = "${back_notify_url}" name="back_notify_url"/>
<input type="hidden" value = "${cert_type}" name="cert_type"/>
<input type="hidden" value = "${cert_no}" name="cert_no"/>
<input type="hidden" value = "${cardholder_name}" name="cardholder_name"/>
<input type="hidden" value = "${user_id}" name="user_id"/>
</form>
</body>
</html>