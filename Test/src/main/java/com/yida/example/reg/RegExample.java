/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.example.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年8月1日 下午1:28:13
 ***********************
 */
public class RegExample {
	private static Pattern REPLACE_PATTERN = Pattern.compile("\\$\\{([\\s\\S]*?)\\}");

	public static void main(String[] args) {
		String readString = "${sjdfioxcsdfj}";

		Matcher matcher = REPLACE_PATTERN.matcher(readString);
		while (matcher.find()) {
			String group = matcher.group(1);
			System.out.println(group);
		}
	}
}
