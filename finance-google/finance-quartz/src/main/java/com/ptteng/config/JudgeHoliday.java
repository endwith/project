package com.ptteng.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JudgeHoliday {
    public Boolean judgeHoliday() {
        Boolean judgeState = false;
        BufferedReader in = null;
        StringBuffer sb = new StringBuffer();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            String time = sdf.format(calendar.getTime());
            URL url = new URL("http://api.goseek.cn/Tools/holiday?date=" + time);
            in = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
            String str = null;
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }
            //json串转化为json对象
            System.out.println(sb.toString());
            if (sb.toString().contains("\"data\":0")) {
                return judgeState;
            }
        } catch (Exception ex) {
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }

        }
        return true;
    }
}
