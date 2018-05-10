package com.yida;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.yida.utils.StreamUtils;

/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午2:59:50
 ***********************
 */
public class Test {
	public static void main(String[] args) {
		File file = new File("C:\\Users\\0\\Desktop\\打包.zip");
		InputStream in = null;
		ByteArrayOutputStream bos = null;
		try {
			in = new FileInputStream("C:\\Users\\0\\Desktop\\打包.zip");
			StreamUtils.inputstreamToFile(in, new File("C:\\Users\\0\\Desktop\\temp\\" + file.getName()));
			System.err.println("success");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
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
