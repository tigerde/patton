package com.huntor.tools;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * 项目名称：账号安全中心(all)   
 * 类名称：DateUtil   
 * 类描述：   时间操作工具
 * 创建人：linwu   
 * 创建时间：2014-12-17 上午10:43:08       
 * @version
 */
public class DateUtil {

	/**
	 * 生成ISO-8601 规范的时间格式
	 * @param date
	 * @return
	 */
	public static String formatISO8601DateString(Date date){
		String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		return  DateFormatUtils.format(date, pattern);
	}
	
	
	/**
	 * 获取反时间戳
	 * @return
	 */
	public static Long getCurrentReverseTime(){
		long longTime = System.currentTimeMillis()*1000000 + CalculateUtil.getNext(999999);
		return Long.MAX_VALUE - longTime;
	}
	
	/**
	 * 获取原时间戳
	 * @param reverseTime
	 * @return
	 */
	public static Long recoverReverseTime(Long reverseTime){
		long longTime = Long.MAX_VALUE - reverseTime;
		return longTime/1000000;
	}
	/**
	 * 生成页面普通展示时间
	 * @param date
	 * @return
	 */
	public static String formatNormalDateString(Date date){
		String pattern = "yyyy-MM-dd HH:mm:ss";
		return DateFormatUtils.format(date, pattern);
	}
	/**
	 * 生成日期yyyy-MM-dd
	 * @param date
	 * @return
	 */
	public static String formatDateString(Date date){
		String pattern = "yyyy-MM-dd";
		return DateFormatUtils.format(date, pattern);
	}
	/**
	 * 小于当前days天时间
	 * @param date
	 * @return
	 */
	public static Date formatReduceDateString(Date date,int days){
		date.setTime(date.getTime()-days*24*60*60*1000l);
		return date;
	}

	/**
	 * 获取指定日期当天的开始时间
	 * @param date 日期
	 * @return 时间
	 */
	public static Date startOfDay(Date date) {
		return new DateTime(date).withTimeAtStartOfDay().toDate();
	}
	
}
