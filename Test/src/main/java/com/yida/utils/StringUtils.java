package com.yida.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.gson.Gson;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月12日 下午2:29:05
 ***********************
 */
public final class StringUtils {
	public static void main(String[] args) {
		/*
		 * String randomJianHan = getRandomJianHan(5);
		 * System.err.println(randomJianHan);
		 */
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (int i = 0; i < 10; i++) {
			String randomJianHan = getRandomJianHan(100);
			Map<String, String> map = new HashMap<String, String>();
			map.put("text", randomJianHan);
			list.add(map);
		}
		String json = new Gson().toJson(list);
		FileUtils.writeFile(json, new File("src/main/resources/aaa.json"));
	}

	public static void cycleCount(int k) {
		Random rd = new Random();
		int m = 0;// 生成0-26的随机数
		for (int j = 0; j < k; j++) {
			String n = "";
			for (int i = 0; i < 26; i++) {
				String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
				m = rd.nextInt(62);
				n = n + str.charAt(m);
			}
			System.out.println("n:" + n.toLowerCase());
		}
	}

	// 获得指定长度的随机基本字符串
	public static String getBaseRandString(int maxLength) {
		String source = "abcdefghijklmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sb = new StringBuffer();
		Random rand = new Random();
		for (int i = 0; i < maxLength; i++) {
			sb.append(source.charAt(rand.nextInt(source.length())));
		}
		return sb.toString();
	}

	/**
	 * 获取指定长度随机简体中文
	 * 
	 * @param len
	 *            int
	 * @return String
	 */
	public static String getRandomJianHan(int len) {
		String ret = "";
		for (int i = 0; i < len; i++) {
			String str = null;
			int hightPos, lowPos; // 定义高低位
			Random random = new Random();
			hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
			lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
			byte[] b = new byte[2];
			b[0] = (new Integer(hightPos).byteValue());
			b[1] = (new Integer(lowPos).byteValue());
			try {
				str = new String(b, "GBk"); // 转成中文
			} catch (UnsupportedEncodingException ex) {
				ex.printStackTrace();
			}
			ret += str;
		}
		return ret;
	}

	public static boolean isEmpty(String charsetName) {
		if (charsetName == null || charsetName.isEmpty()) {
			return true;
		}
		return false;
	}
}
