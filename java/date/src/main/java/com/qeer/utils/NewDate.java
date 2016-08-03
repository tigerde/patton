package com.qeer.utils;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class NewDate {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println("日期输出：" + millis);
        Instant instant = clock.instant();
        Date date = Date.from(instant);
        System.out.println("日期输出：" + date.getTime());
        LocalDate localDate=LocalDate.now();
        System.out.println("当前日期:"+localDate.getYear()+"-"+localDate.getMonthValue()+"-"+localDate.getDayOfMonth());
        LocalTime localTime=LocalTime.now();
        System.out.println("当前时间："+localTime.getHour()+":"+localTime.getMinute()+":"+localTime.getSecond());
        LocalDateTime dateTime=LocalDateTime.now();
        System.out.println("当前时间:"+dateTime.toString());
        
        ZonedDateTime zonedDateTime=ZonedDateTime.now();
        //时区id选值
        System.out.println("时区选值：");
        ZoneId.SHORT_IDS.forEach((a,b)->System.out.println(a+":"+b));
        //时间格式化
        DateTimeFormatter dtFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(dtFormatter.toString());
        String str=dateTime.format(dtFormatter);
        System.out.println("format:"+str);
    }
}
