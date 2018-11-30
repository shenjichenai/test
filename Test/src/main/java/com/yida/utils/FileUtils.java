/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

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

	public static void writeFile(String content, File file) {
		writeFile(content, file, "UTF-8");
	}

	public static void writeFile(String content, File file, String charsetName) {
		OutputStreamWriter osw = null;

		try {
			ensureParentPath(file);
			if (StringUtils.isEmpty(charsetName)) {
				charsetName = "UTF-8";
			}

			osw = new OutputStreamWriter(new FileOutputStream(file), charsetName);
			osw.write(content);
			osw.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					;
				}
			}

		}

	}

	public static void writeFile(ByteArrayInputStream inputStream, File outFile) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		int len;
		ensureParentPath(outFile);
		try {
			while ((len = inputStream.read(b)) != -1) {
				output.write(b, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getFileExtension(File file) {
		String filename = file.getName();
		return filename.substring(filename.lastIndexOf("."));
	}
}
