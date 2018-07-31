package com.ptteng.quartz.job;

import com.ptteng.model.HistoryProduct;
import com.ptteng.model.Trade;
import com.ptteng.model.User;
import com.ptteng.service.HistoryProductService;
import com.ptteng.service.TradeService;
import com.ptteng.service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReturnInterestJob implements Job {
@Autowired
private TradeService tradeService;
@Autowired
private RedisTemplate redisTemplate;
@Autowired
private UserService userService;
@Autowired
private HistoryProductService historyProductService;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        org.slf4j.Logger logger = LoggerFactory.getLogger(ReturnInterestJob.class);
        try {
            long total = tradeService.selectReturnInterest();
            int page = (int) (total / 5 + 1);
            for (int i = 0; i < page; i++) {
                List<Trade> tradeList = tradeService.forReturnInterest(i * 5l, 5l);
                for (Trade trade : tradeList) {
                    SimpleDateFormat sdf = new SimpleDateFormat("MM");
                    int realMonth = Integer.valueOf(sdf.format(new Date().getTime()));
                    int expireMonth = Integer.valueOf(sdf.format(trade.getExpireTime()));
                    User user = userService.selectByPrimaryKey(trade.getUserId());
                    if (trade.getStatus() == 0 || trade.getStatus() == 2) {
                        if (trade.getExpireTime() > new Date().getTime() && realMonth < expireMonth) {
                            //计算月利息
                            BigDecimal bigDecimal = new BigDecimal(100 * 12);
                            BigDecimal interest = trade.getPurchaseAmount().multiply(trade.getExpectedRate()).divide(bigDecimal);
                            //用户的累计收入
                            user.setAccumulIncome(user.getAccumulIncome().add(interest));
                            userService.updateByPrimaryKeySelective(user);
                            //历史记录表加入返息的记录
                            HistoryProduct historyProduct = new HistoryProduct();
                            historyProduct.setBuyer(user.getTrueName());
                            historyProduct.setArriveTime(trade.getExpireTime());
                            historyProduct.setBankCard("");
                            historyProduct.setPhone(user.getPhone());
                            historyProduct.setProduct(trade.getProduct());
                            historyProduct.setTransactionAction(0);
                            historyProduct.setTransactionAmouont(interest);
                            historyProductService.insert(historyProduct);
                        }
                    } else if (realMonth == expireMonth) {
                        //预约的最后一个月只打利息
                        //计算月利息
                        BigDecimal bigDecimal = new BigDecimal(100 * 12);
                        BigDecimal interest = trade.getPurchaseAmount().multiply(trade.getExpectedRate()).divide(bigDecimal);
                        //用户的累计收入
                        user.setAccumulIncome(user.getAccumulIncome().add(interest));
                        userService.updateByPrimaryKeySelective(user);
                        //历史记录表加入返息的记录
                        HistoryProduct historyProduct = new HistoryProduct();
                        historyProduct.setBuyer(user.getTrueName());
                        historyProduct.setArriveTime(trade.getExpireTime());
                        historyProduct.setBankCard("");
                        historyProduct.setPhone(user.getPhone());
                        historyProduct.setProduct(trade.getProduct());
                        historyProduct.setTransactionAction(0);
                        historyProduct.setTransactionAmouont(interest);
                        historyProductService.insert(historyProduct);
                    }
                }
            }
        }catch (Exception e){
            logger.info("错误,{}",e);
        }


    }
}
