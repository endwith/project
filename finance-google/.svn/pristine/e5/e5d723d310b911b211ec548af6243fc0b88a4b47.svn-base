package com.ptteng.quartz.job;

import com.ptteng.model.HistoryProduct;
import com.ptteng.model.InvestmentContract;
import com.ptteng.model.Trade;
import com.ptteng.model.User;
import com.ptteng.service.HistoryProductService;
import com.ptteng.service.InvestmentContractService;
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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReturnAccountAllJob implements Job {

    @Autowired
    private TradeService tradeService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;
    @Autowired
    private HistoryProductService historyProductService;
    @Autowired
    private InvestmentContractService investmentContractService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        org.slf4j.Logger logger = LoggerFactory.getLogger(ReturnAccountAllJob.class);
        long total = tradeService.selectReturnInterest();
        try{
        int page = (int) (total/5+1);
        for(int i =0; i<page;i++) {
            List<Trade> tradeList = tradeService.forReturnInterest(i * 5l, 5l);
            for (Trade trade : tradeList) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd");
                int realDay = Integer.valueOf(sdf.format(new Date().getTime()));
                int expireDay = Integer.valueOf(sdf.format(trade.getExpireTime()));
                if (realDay == expireDay) {
                    //判断是否预约了
                    User user = userService.selectByPrimaryKey(trade.getUserId());
                    if (trade.getStatus() == 0 || trade.getStatus() == 2) {
                        //计算月利息
                        BigDecimal bigDecimal = new BigDecimal(100 * 12);
                        BigDecimal interest = trade.getPurchaseAmount().multiply(trade.getExpectedRate()).divide(bigDecimal);
                        //用户的累计收入
                        //用户全部资产减少

                        user.setAccumulIncome(user.getAccumulIncome().add(interest));//
                        //     user.setTotalAssets(user.getTotalAssets().subtract(trade.getPurchaseAmount()));//
                        userService.updateByPrimaryKeySelective(user);
                        //历史记录表加入返息的记录
                        HistoryProduct historyProduct = new HistoryProduct();
                        historyProduct.setBuyer(user.getTrueName());
                        historyProduct.setArriveTime(trade.getExpireTime());
                        historyProduct.setBankCard("");
                        historyProduct.setPhone(user.getPhone());
                        historyProduct.setProduct(trade.getProduct());
                        historyProduct.setTransactionAction(1);
                        historyProduct.setTransactionAmouont(interest.add(trade.getPurchaseAmount()));//本息返还
                        historyProductService.insert(historyProduct);
                        //投资合同改状态
                        investmentContractService.updateInvestOutOfDate(user.getId());
                        //删除当前交易表
                        tradeService.deleteByPrimaryKey(trade.getId());
                    } else {
                        //预约变成新的投资合同
                        //之前的也放入历史纪录中
                        //本金表变化成续约的
                        trade.setBuyTime(trade.getExpireTime());
                        trade.setExpireTime(trade.getBuyTime() + trade.getExpireTime() * 1000 * 3600 * 24l);
                        trade.setStatus(trade.getStatus() - 1);
                        InvestmentContract investmentContract = new InvestmentContract();
                        investmentContract.setEffectiveTime(trade.getBuyTime());
                        investmentContract.setInvalidTime(trade.getExpireTime());
                        investmentContract.setInvestAmount(trade.getPurchaseAmount());
                        investmentContract.setPhoneNumber(user.getPhone());
                        investmentContract.setTrueName(user.getTrueName());
                        investmentContract.setProduct(trade.getProduct());
                        investmentContract.setIncome(trade.getExpectedRate().divide(new BigDecimal(100)).multiply(trade.getPurchaseAmount().multiply(new BigDecimal(trade.getDelayTime()).divide(new BigDecimal(360)))));
                        investmentContract.setUserId(user.getId());
                        investmentContract.setStatus(0);
                        investmentContractService.insertSelective(investmentContract);
                        trade.setInvestmentContractId(investmentContract.getId());
                        tradeService.updateByPrimaryKeySelective(trade);
                    }
                }
            }
        }
        }catch (Exception e){
            logger.info("错误{}",e);
        }
        }
    }


