package com.yida.cutimage;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *********************
 * 方法类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月24日 下午3:58:37
 ***********************
 */
public class ConstantsUtils {
	public static String IMG_WRITE_PATH = ""; // 图片写入路径

	public static String DRIVER_URL = "";

	public static String USERNAME = "";

	public static String PASSWORD = "";

	public static final String FILE_SHORTCUT_URL = "shortCut";// 根据大数据返回来的稿件URL保存截图

	/**
	 * 静态变量初始化方法
	 */
	public static void init() throws Exception {
		// String filePath =
		// ConstantsUtils.class.getResource("/").getPath().concat("screen_short.xml");
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream is = loader.getResourceAsStream("screen_short.xml");
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();

		SAXReader reader = new SAXReader();
		Document document = reader.read(is);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		@SuppressWarnings("unchecked")
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList)
			map.put(e.getName(), e.getText());

		// 获取配置文件中的值
		IMG_WRITE_PATH = map.get("IMG_WRITE_PATH");
		DRIVER_URL = map.get("DRIVER_URL");
		USERNAME = map.get("USERNAME");
		PASSWORD = map.get("PASSWORD");
	}

}
