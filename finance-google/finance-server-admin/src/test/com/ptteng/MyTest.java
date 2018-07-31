package com.ptteng;

import com.ptteng.model.Trade;
import com.ptteng.service.*;
import com.ptteng.util.CheckPhone;
import com.ptteng.util.Token;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MyTest {
@Resource
InformationManageService informationManageService;
@Resource
private Token token;
    @Resource
    private BackstageAccountService backstageAccountService;
    @Resource
    private ObligatoryRightService obligatoryRightService;
    @Resource
    private ModuleManageService moduleManageService;
    @Resource
    private TradeService tradeService;
    @Test
    public void Testtt(){
//        System.out.println("*****************"+backstageAccountService.selectCount());
        CheckPhone checkPhone=new CheckPhone();
        if(!checkPhone.isPhone("11111111111")){
            System.out.println("111111111111111111111111");
        }

    }
    @Test
    public void tswwet() {
        System.out.println(informationManageService.selectCount());
    }
    @Test
    public void tswswet() {
        BigDecimal matchingAmount=BigDecimal.valueOf(10000);
        BigDecimal toBeMatched=BigDecimal.valueOf(100000);
        System.out.println(matchingAmount.subtract(toBeMatched).compareTo(BigDecimal.valueOf(0)));
    }




}
