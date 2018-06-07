package com.cp.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description
 * @Author wangsai
 * @Date 2018/5/14 10:07
 **/
public class DateUtil {

    public static Date addDay(Date origin, Integer days){
        if (origin == null) {
            origin = new Date();
        }
        Calendar cal = Calendar.getInstance();

        cal.setTime(origin);

        // 计算并累加日期
        cal.add(Calendar.DATE, days);

        return cal.getTime();
    }
}
