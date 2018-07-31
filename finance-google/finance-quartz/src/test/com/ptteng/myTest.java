package com.ptteng;

import com.ptteng.service.HistoryProductService;
import com.ptteng.service.InformationManageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class myTest {
    @Resource
    private InformationManageService informationManageService;
    @Resource
    private HistoryProductService historyProductService;
    @Test
    public void tsettt(){
       informationManageService.selectInforByRead(1L,1L);
    }
    @Test
    public void tswwettt(){
    }
    @Test
    public void tswwett() {
        System.out.println(informationManageService.selectCount());
    }
}
