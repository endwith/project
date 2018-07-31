package com.ptteng.quartz.job;

import com.ptteng.model.HistoryProduct;
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

public class ReturnAllMoneyJob implements Job {
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
        try {
            long total = tradeService.selectReturnPrincipal();
            int page = (int) (total / 5 + 1);
            for (int i = 0; i < page; i++) {
                List<Trade> tradeList = tradeService.forReturnPrincipal(i * 5l, 5l);
                for (Trade trade : tradeList) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd");
                    int realDay = Integer.valueOf(sdf.format(new Date().getTime()));
                    int expireDay = Integer.valueOf(sdf.format(trade.getExpireTime()));
                    if (realDay == expireDay) {
                        //计算全部利息
                        BigDecimal bigDecimal = new BigDecimal(100 * 360 / trade.getDelayTime());
                        BigDecimal interest = trade.getPurchaseAmount().multiply(trade.getExpectedRate()).divide(bigDecimal);
                        //用户的累计收入
                        //用户全部资产减少
                        User user = userService.selectByPrimaryKey(trade.getUserId());
                        user.setAccumulIncome(user.getAccumulIncome().add(interest));//
                        //    user.setTotalAssets(user.getTotalAssets().subtract(trade.getPurchaseAmount()));//
                        userService.updateByPrimaryKeySelective(user);
                        //投资合同改状态
                        investmentContractService.updateInvestOutOfDate(user.getId());
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
                        //删除当前交易表
                        tradeService.deleteByPrimaryKey(trade.getId());
                    }
                }
            }
        }catch (Exception e){
            logger.info("错误",e);
        }
    }
}
