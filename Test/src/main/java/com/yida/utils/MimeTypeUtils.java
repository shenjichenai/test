/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.utils;

import java.io.File;

import javax.activation.MimetypesFileTypeMap;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年10月23日 上午9:53:53
 ***********************
 */
public class MimeTypeUtils {
	/**
	 * 获取文件MimeType
	 * 
	 * @param filePath
	 *            目标文件
	 * @return MimeType
	 * @Date 2018年10月23日09:54:23
	 */
	public static String getMimeType(File file) {
		return new MimetypesFileTypeMap().getContentType(file);
	}

	/**
	 * 获取文件MimeType
	 * 
	 * @param filePath
	 *            目标文件的绝对路径
	 * @return MimeType
	 * @Date 2018年10月23日09:54:23
	 */
	public static String getMimeType(String filePath) {
		return new MimetypesFileTypeMap().getContentType(filePath);
	}

	public static void main(String[] args) {
		System.err.println(getMimeType("E:\\yk\\temp\\file\\51018100000000_lyr.mdb"));
	}
}
