/**
 */
package com.yida.base.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月7日 下午12:18:33
 ***********************
 */
public class StreamTest {
	public static void main(String[] args) {
		int charSizeFromFile = getCharSizeFromFileByStream("a");
		System.err.println(charSizeFromFile);
	}

	@SuppressWarnings({ "resource", "unused" })
	public static int getCharSizeFromFile(String c) {

		try {
			FileReader fileReader = new FileReader(new File("C:\\Users\\0\\Desktop\\AmqConnectTest.java"));
			char[] b = new char[1024];
			int len;
			StringBuilder sb = new StringBuilder();
			while ((len = fileReader.read(b, 0, b.length)) != -1) {
				sb.append(String.valueOf(b));
			}
			int oldLength = sb.toString().length();
			int newLength = sb.toString().replaceAll(c, "").length();
			return oldLength - newLength;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@SuppressWarnings({ "resource", "unused" })
	public static int getCharSizeFromFileByStream(String c) {
		try {
			FileInputStream in = new FileInputStream(new File("C:\\Users\\0\\Desktop\\AmqConnectTest.java"));
			byte[] b = new byte[1024];
			int len;
			StringBuilder sb = new StringBuilder();
			while ((len = in.read(b)) != -1) {
				sb.equals(new String(b));
			}
			int oldLength = sb.toString().length();
			int newLength = sb.toString().replaceAll(c, "").length();
			return oldLength - newLength;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
