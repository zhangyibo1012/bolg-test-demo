package com.zyb.utils;

import com.zyb.constant.GlobalConstant;
import org.apache.tomcat.jni.Local;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @Title: DataUtil.java
 * @Package com.zyb
 * @Description:
 *      SimpleDateFormat源码中所有格式化和解析都需要一个中间对象进行转换，那就是Calendar，而这个类也是出现线程不安全的罪魁祸首，当我们有多个线程操作同一个Calender的时候后来的后来的线程会覆盖先来线程的数据，那最后返回的是后来的线程的数据，数据不准确
 *      LocalDate无法包含时间
 *      LocalTime无法包含日期
 *      LocalDateTime同时包含日期和时间
 *
 * @Author ZhangYB
 * @Version V1.0
 */
public class DataUtil {

    /**
     * 获取当前时间
     * @return
     */
    public static LocalDateTime getLocalDateTime(){
        return LocalDateTime.now();
    }

    /**
     * localdateTime转换位毫秒值
     * @param time  LocalDateTime
     * @return
     */
    public static long localDateTime2Millisecond(LocalDateTime time){
        return time.atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli();
    }

    /**
     * 毫秒转换位localDateTime
     * @param sa
     * @return
     */
    public static LocalDateTime millisecond2LocalDateTime(long sa){
        return Instant.ofEpochMilli(sa).atZone(ZoneId.of("Asia/Shanghai")).toLocalDateTime();
    }

    /**
     * 时间格式化
     * @param time  localDateTime
     * @param pattern 模式
     * @return
     */
    public static String format(LocalDateTime time , String pattern){
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 日期加运算
     * @param time  LocalDateTime
     * @param number 加的数字
     * @param field  ChronoUnit枚举值 DAYS等 根据field不同加不同的值
     * @return
     */
    public static LocalDateTime plus(LocalDateTime time , long number , TemporalUnit field){
        return time.plus(number,field);
    }

    /**
     * 日期加运算
     * @param time  LocalDateTime
     * @param number 减的数字
     * @param field  ChronoUnit枚举值 DAYS等 根据field不同减不同的值
     * @return
     */
    public static LocalDateTime minu(LocalDateTime time , long number , TemporalUnit field){
        return time.minus(number,field);
    }

    /**
     * date 转换LocalDate
     * @param date
     * @return
     */
    public static LocalDateTime date2LDT(Date date){
        return LocalDateTime.ofInstant(date.toInstant() , ZoneId.systemDefault());
    }

    /**
     * LocalDateTime 转换位date
     * @param time
     * @return
     */
    public static Date lDT2Date(LocalDateTime time){
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取当天start零点00:00:00   2016-07-23T00:00
     * @return  需要格式化
     */
    public static LocalDateTime today_start(){
        return LocalDateTime.of(LocalDate.now() ,LocalTime.MIN);
    }

    /**
     * 获取当天end零点59:59:59  2016-07-23T23:59:59.999999999
     * @return   需要格式化
     */
    public static LocalDateTime today_end(){
        return LocalDateTime.of(LocalDate.now() ,LocalTime.MAX);
    }

    /**
     * 获取当前时间并格式化
     * @return
     */
    public static String getCurrentTimeFormat(){
        return format(getLocalDateTime() ,GlobalConstant.DATE_FORMAT);
    }

    /**
     * 设定时间
     *
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static Date bookTime(int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        Date date = calendar.getTime();
        return date;
    }

    public static void main(String[] args) {
      final String pattern = "yyyy-MM-dd HH:mm:ss";
        System.out.println(today_end());
    }

}
