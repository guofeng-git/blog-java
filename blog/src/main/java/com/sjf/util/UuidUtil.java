package com.sjf.util;

import java.util.UUID;
/**
 * 
 * @ClassName:     UuidUtil
 * @Description:   通用的获取32位UUID的工具类
 * @author:        lacet
 * @date:          2019年3月28日 下午12:46:29
 *
 */
public class UuidUtil {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}
	
//	public static void main(String[] args) {
//		System.out.println(get32UUID());
//	}
}

