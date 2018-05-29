/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月28日 下午3:53:37
 ***********************
 */
public class DateUtils {

	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_TIME24_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static String formatDate(Date date, String dateFormat) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		return simpleDateFormat.format(date);
	}

}
