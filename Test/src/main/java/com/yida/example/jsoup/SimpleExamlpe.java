/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.example.jsoup;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年9月19日 上午11:19:12
 ***********************
 */
public class SimpleExamlpe {
	public static void main(String[] args) throws IOException, ParseException {
		File input = new File("C:\\Users\\0\\Desktop\\shanxi.html");
		Document doc = Jsoup.parse(input, "UTF-8");

		Elements trs = doc.select("tbody tr");
		for (Element tr : trs) {
			Elements td = tr.select("td");
			String url = td.get(2).select("a").attr("href");
			String title = td.get(2).text();
			String dateStr = td.get(3).text();
			DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format1.parse(dateStr);

			System.out.println(url);
			System.out.println(title);
			System.out.println(date);

		}
		Elements active = doc.select("ul").get(1).select("li[class='active']");
		String next = active.next().text();
		System.out.println(next);
	}
}
