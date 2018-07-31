package com.ptteng.quartz.job;

import com.ptteng.model.InformationManage;
import com.ptteng.service.InformationManageService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InformationSchedulerJob implements Job {

    org.slf4j.Logger logger = LoggerFactory.getLogger(InformationSchedulerJob.class);

    @Autowired
private InformationManageService informationManageService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<InformationManage> informationManageList = informationManageService.selectAll();
            for (InformationManage informationManage : informationManageList) {
                if (Math.abs(informationManage.getSendTime() - new Date().getTime()) <= 10 * 1000) {
                    informationManage.setInforStatus(1);
                    informationManageService.updateByPrimaryKeySelective(informationManage);
                    logger.info("消息推送： " + informationManage.getInforTitle() + "时间: " + dateFormat.format(informationManage.getSendTime()));
                }
            }
        }catch (Exception e){
            logger.info("错误{}",e);
        }
    }

}