package com.ptteng;

import com.ptteng.model.InvestmentContract;
import com.ptteng.service.HistoryProductService;
import com.ptteng.service.InformationManageService;
import com.ptteng.service.InvestmentContractService;
import com.ptteng.service.MessageRelationshipService;
import com.ptteng.util.ElTest;
import com.ptteng.util.FuiouUtil;
import com.ptteng.util.Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//
@RunWith(SpringRunner.class)
@SpringBootTest
public class myTest {
    @Resource
    private MessageRelationshipService messageRelationshipService;
    @Resource
    private InvestmentContractService investmentContractService;
    @Resource
    private InformationManageService informationManageService;
    @Resource
    private HistoryProductService historyProductService;
    @Test
    public void tsettt(){
       informationManageService.selectInforByRead(1L,1L);
    }
    @Test
    public void tsetSStt(){
        historyProductService.selectCount(1L);
    }
    @Test
    public void tswwett(){
        ElTest elTest=new ElTest();
        List<Map> historyProducts;
    Map<String,Object> map=new HashMap<>();

                historyProducts = historyProductService.selectByProduct("聚月增", 0L , 5L);

            for (Map i : historyProducts) {
                i.put("trueName", elTest.getNameWith(String.valueOf(i.get("trueName"))));
            }
        System.out.println(historyProducts.toString());
        }
@Test
    public void t() throws Exception {
    FuiouUtil fuiouUtil=new FuiouUtil();
    String respStr=fuiouUtil.checkBankCard("张三","430524199311257436","6216611500001664560");
    String reg = "[^\u4e00-\u9fa5]";
    respStr = respStr.replaceAll(reg, "");
    if(respStr.contains("成功")){
        respStr = respStr.replaceAll("成功", "");
        System.out.println("**********"+1);
    }else {
        System.out.println("**********"+2);
    }
}

@Test

public void tw() throws Exception {
    Token token=new Token();
        ElTest elTest=new ElTest();
    System.out.println(token.SolveToken("9297e4ec9632dcb3e7c0f3136cc2286d238487dad385b7d7bd18e6530bb791bf"));
    System.out.println(elTest.getBank(token.SolveToken("9297e4ec9632dcb3e7c0f3136cc2286d238487dad385b7d7bd18e6530bb791bf")));

}
@Test
    public void ttt() throws Exception {

FuiouUtil fuiouUtil=new FuiouUtil();
    String str = fuiouUtil.checkBankCard("隆航", "430524199311257436", "6236682060000227778");
    if (str.contains("成功")) {
        String reg = "[^\u4e00-\u9fa5]";
        str = str.replaceAll(reg, "");

        str = str.replace("成功", "");
        if (str.contains("中国")) {
            str = str.replace("中国", "");
        }
        System.out.println(str);
    }
}
    @Test
    public void ttts() throws Exception {
        List<Object> informations;
        List<Long> s =messageRelationshipService.selectByUserId(33L);
        System.out.println("*****"+s.toString());
        informations=informationManageService.selectInforByReadList(s,5L);
        System.out.println("*****"+informations.toString());
    }
}
