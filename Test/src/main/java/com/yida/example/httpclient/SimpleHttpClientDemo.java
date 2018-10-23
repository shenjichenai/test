/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.example.httpclient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年9月19日 上午10:35:11
 ***********************
 */
public class SimpleHttpClientDemo {

	public static void main(String[] args) throws ParseException, IOException {
		String url = "http://php.weather.sina.com.cn/iframe/index/w_cl.php";
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", "js");
		map.put("day", "0");
		map.put("city", "上海");
		map.put("dfc", "1");
		map.put("charset", "utf-8");
		String body = post(url, map, "utf-8");
		System.out.println("交易响应结果：");
		System.out.println(body);

		System.out.println("-----------------------------------");

		map.put("city", "北京");
		body = post(url, map, "utf-8");
		System.out.println("交易响应结果：");
		System.out.println(body);
	}

	/**
	 * httpclient get请求
	 * 
	 * @throws Exception
	 */
	public static void get() throws Exception {

		// 创建一个httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();

		// 创建URIBuilder
		URIBuilder uri = new URIBuilder("http://localhost:8080/api/httpClientTestGet.do");

		// 设置参数
		uri.addParameter("id", "10001");

		// 创建httpGet对象
		HttpGet hg = new HttpGet(uri.build());

		// 设置请求的报文头部的编码
		hg.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));

		// 设置期望服务端返回的编码
		hg.setHeader(new BasicHeader("Accept", "text/plain;charset=utf-8"));

		// 请求服务
		CloseableHttpResponse response = client.execute(hg);

		// 获取响应码
		int statusCode = response.getStatusLine().getStatusCode();

		if (statusCode == 200) {

			// 获取返回实例entity
			HttpEntity entity = response.getEntity();

			// 通过EntityUtils的一个工具方法获取返回内容
			String resStr = EntityUtils.toString(entity, "utf-8");

			// 输出
			System.out.println("请求成功,请求返回内容为: " + resStr);
		} else {

			// 输出
			System.out.println("请求失败,错误码为: " + statusCode);
		}

		// 关闭response和client
		response.close();
		client.close();
	}

	/**
	 * 模拟请求
	 * 
	 * @param url
	 *            资源地址
	 * @param map
	 *            参数列表
	 * @param encoding
	 *            编码
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static String post(String url, Map<String, String> map, String encoding) throws ParseException, IOException {
		String body = "";

		// 创建httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		// 创建post方式请求对象
		HttpPost httpPost = new HttpPost(url);

		// 装填参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (map != null) {
			for (Entry<String, String> entry : map.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		// 设置参数到请求对象中
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));

		System.out.println("请求地址：" + url);
		System.out.println("请求参数：" + nvps.toString());

		// 设置header信息
		// 指定报文头【Content-type】、【User-Agent】
		httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
		httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		// 执行请求操作，并拿到结果（同步阻塞）
		CloseableHttpResponse response = client.execute(httpPost);
		// 获取结果实体
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			// 按指定编码转换结果实体为String类型
			body = EntityUtils.toString(entity, encoding);
		}
		EntityUtils.consume(entity);
		// 释放链接
		response.close();
		return body;
	}

}
