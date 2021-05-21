package com.sjf.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @ClassName:     DateFormatUtil
 * @Description:   时间转换工具类
 * @author:        lacet
 * @date:          2019年3月28日 下午12:48:16
 *
 */
public class DateFormatUtil {
	public static String getCurrentTime24SSS(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}
	public static String getCurrentTime14(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
	
	public static String getCurrentTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date());
	}
	
	public static String getCurrentTime6(){
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return sdf.format(new Date());
	}

}
