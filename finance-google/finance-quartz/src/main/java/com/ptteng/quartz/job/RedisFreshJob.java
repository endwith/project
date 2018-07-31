package com.ptteng.quartz.job;



import com.ptteng.config.JudgeHoliday;
import java.util.Calendar;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

public class RedisFreshJob implements Job {

    @Autowired
    private RedisTemplate redisTemplate;



    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        redisTemplate.delete(redisTemplate.keys("googleSms"+"*"));
        redisTemplate.delete(redisTemplate.keys("googleRegister"+"*"));
        redisTemplate.delete(redisTemplate.keys("googlePicture"+"*"));
        JudgeHoliday judgeHoliday = new JudgeHoliday();
        Calendar calendar = Calendar.getInstance();
        if(judgeHoliday.judgeHoliday()){
            redisTemplate.opsForValue().set("googleJudgeHolidayStatus",1);
            redisTemplate.opsForValue().set("googleJudgeHoliday",calendar.get(Calendar.DATE));

        }else {
            redisTemplate.opsForValue().set("googleJudgeHolidayStatus",0);
            redisTemplate.opsForValue().set("googleJudgeHoliday",calendar.get(Calendar.DATE));
        }

    }

}
