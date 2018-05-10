/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.utils;

import java.io.File;

/**
 *********************
 * 文件通用方法
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午2:17:43
 ***********************
 */
public final class FileUtils {
	/**
	 * 判断父路径是否存在
	 * 
	 * @param file
	 * @return
	 */
	public static boolean ensureParentPath(File file) {
		File parentFile = file.getParentFile();
		return parentFile == null ? true : (parentFile.exists() ? !parentFile.isFile() : parentFile.mkdirs());
	}
}
