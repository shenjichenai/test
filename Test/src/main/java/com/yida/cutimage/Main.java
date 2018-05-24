package com.yida.cutimage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
	public static void main(String[] args) {
		try {
			List<String> urls = new ArrayList<>();
			urls.add("https://www.baidu.com/");
			List<String> paths = new ArrayList<>();
			paths.add("C:\\Users\\Administrator\\Desktop\\新建文件夹\\" + UUID.randomUUID() + ".JPG");
			EagleBrowser.main1(urls, paths);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
