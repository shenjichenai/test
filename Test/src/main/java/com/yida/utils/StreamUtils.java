package com.yida.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *********************
 * 流通用方法
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午12:13:12
 ***********************
 */
public final class StreamUtils {
	/**
	 * 字符转文件
	 * 
	 * @param buf
	 * @param file
	 */
	public static void bytesToFile(byte[] buf, File file) {
		BufferedOutputStream bos = null;
		try {
			FileUtils.ensureParentPath(file);
			bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(buf);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (bos != null) {
				try {
					bos.flush();
					bos.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * 流转文件
	 * 
	 * @param is
	 * @param file
	 */
	public static void inputstreamToFile(InputStream in, File file) {
		BufferedOutputStream bos = null;
		try {
			FileUtils.ensureParentPath(file);
			bos = new BufferedOutputStream(new FileOutputStream(file));
			byte[] b = new byte[8196];
			int len;
			while ((len = in.read(b)) != -1) {
				bos.write(b, 0, len);
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (bos != null) {
				try {
					bos.flush();
					bos.close();
				} catch (IOException e) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
