package com.ptteng.util;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 获取2张银行卡的银行和卡号的前后4位
 */
@Configuration
public class ElTest {
    /**
     * 获取银行卡
     */
    public String getBank(String bankCard) {
        String bank = null;
        Pattern pat = Pattern.compile("(^[\u4e00-\u9fa5]+)");
        Matcher mat = pat.matcher(bankCard);
        while (mat.find()) {
                bank = mat.group(0);
        }
        return bank;
    }
    /**
     * 获取银行卡号
     */
    public String getOneWithNum(String bankCard) {
        String Bank = null;
        String s = null;
        Map<String, String> map = new HashMap<String, String>();
        //移除汉字
        Pattern pat = Pattern.compile("([\u4e00-\u9fa5]+)");
        Matcher mat = pat.matcher(bankCard);
        while (mat.find()) {
            Bank = mat.group(0);
        }
        String BankCardWithNo = mat.replaceAll("");
        return BankCardWithNo;
    }
    /**
     * 获取银行和卡号前后4位
     */
    public Map<String, String> get(List<String> bankCard) {
        String Bank = null;
        String s = null;
        Map<String, String> map = new HashMap<String, String>();
        //移除汉字
        for(String i:bankCard) {
            Pattern pat = Pattern.compile("([\u4e00-\u9fa5]+)");
            Matcher mat = pat.matcher(i);
            while (mat.find()) {
                Bank = mat.group(0);
            }
            String BankCardWithNo = mat.replaceAll("");

            String regex = "(\\w{4})(.*)(\\w{4})";
            Matcher m = Pattern.compile(regex).matcher(BankCardWithNo);
            if (m.find()) {
                String rep = m.group(2);
                StringBuilder sb = new StringBuilder();
                for (int n= 0; n < rep.length(); n++) {
                    sb.append("*");
                }
                s = BankCardWithNo.replaceAll(rep, sb.toString());
            }
            map.put(s, Bank);
        }
        return map;
    }
    /**
     * 获取银行卡号前后4位
     */
    public String getOne(String bankCard) {
        String Bank = null;
        String s = null;
        Map<String, String> map = new HashMap<String, String>();
        //移除汉字
            Pattern pat = Pattern.compile("([\u4e00-\u9fa5]+)");
            Matcher mat = pat.matcher(bankCard);
            while (mat.find()) {
                Bank = mat.group(0);
            }
            String BankCardWithNo = mat.replaceAll("");

            String regex = "(\\w{4})(.*)(\\w{4})";
            Matcher m = Pattern.compile(regex).matcher(BankCardWithNo);
            if (m.find()) {
                String rep = m.group(2);
                StringBuilder sb = new StringBuilder();
                for (int n= 0; n < rep.length(); n++) {
                    sb.append("*");
                }
                s = BankCardWithNo.replaceAll(rep, sb.toString());
            }
          return s;
        }
    /**
     *
     * 获取银行卡的银行和卡号的前后4位
     */
    public String getOneWithBank(String bankCard) {
        String Bank = null;
        String s = null;
        Map<String, String> map = new HashMap<String, String>();
        String regex = "(\\w{4})(.*)(\\w{4})";
        Matcher m = Pattern.compile(regex).matcher(bankCard);
        if (m.find()) {
            String rep = m.group(2);
            StringBuilder sb = new StringBuilder();
            for (int n= 0; n < rep.length(); n++) {
                sb.append("*");
            }
            s = bankCard.replaceAll(rep, sb.toString());
        }
        return s;
    }
    /**
     *
     * 获取姓名*****
     */
    public String getNameWith(String name) {
        String regex1 = null;
        String regex = name.substring(1);
        if (1 == regex.length()) {
            regex1 = "*";

            if (2 == regex.length()) {
                regex1 = "**";
            }
        } else {
            regex1 = "***";
        }
        return name.replaceAll(regex, regex1);

    }
}