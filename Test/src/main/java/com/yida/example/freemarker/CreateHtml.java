package com.yida.example.freemarker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class CreateHtml {
	public static void main(String[] args) throws IOException, TemplateException {
		/*
		 * ---------------------------------------------------------------------
		 * ---
		 */
		/* You should do this ONLY ONCE in the whole application life-cycle: */

		/* Create and adjust the configuration singleton */
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		String path = CreateHtml.class.getResource("/static").getPath();
		cfg.setDirectoryForTemplateLoading(new File(path));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

		/*
		 * ---------------------------------------------------------------------
		 * ---
		 */
		/*
		 * You usually do these for MULTIPLE TIMES in the application
		 * life-cycle:
		 */

		/* Create a data-model */
		// Map<String, Object> root = new HashMap<String, Object>();
		// root.put("user", "Big Joe");
		// Map<String, Object> latest = new HashMap<String, Object>();
		// root.put("latestProduct", latest);
		// latest.put("url", "products/greenmouse.html");
		// latest.put("name", "green mouse");

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("description", "我正在学习使用Freemarker生成静态文件！");

		List<String> nameList = new ArrayList<String>();
		nameList.add("陈靖仇");
		nameList.add("玉儿");
		nameList.add("宇文拓");
		paramMap.put("nameList", nameList);

		Map<String, Object> weaponMap = new HashMap<String, Object>();
		weaponMap.put("first", "轩辕剑");
		weaponMap.put("second", "崆峒印");
		weaponMap.put("third", "女娲石");
		weaponMap.put("fourth", "神农鼎");
		weaponMap.put("fifth", "伏羲琴");
		weaponMap.put("sixth", "昆仑镜");
		weaponMap.put("seventh", null);
		paramMap.put("weaponMap", weaponMap);

		/* Get the template (uses cache internally) */
		Template temp = cfg.getTemplate("template.html");

		/* Merge data-model with template */
		File file = new File("E:\\yk\\temp\\file\\success_1.html");
		Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		// Writer writer = new OutputStreamWriter(System.out);
		// StringWriter writer = new StringWriter();
		temp.process(paramMap, writer);
		// System.out.println(writer.toString());
		// Note: Depending on what `out` is, you may need to call `out.close()`.
		// This is usually the case for file output, but not for servlet output.
	}

	@SuppressWarnings("deprecation")
	public void test() {
		try {
			// 创建一个合适的Configration对象
			Configuration configuration = new Configuration();
			String path = CreateHtml.class.getResource("/static").getPath();
			configuration.setDirectoryForTemplateLoading(new File(path));
			configuration.setObjectWrapper(new DefaultObjectWrapper());
			configuration.setDefaultEncoding("UTF-8"); // 这个一定要设置，不然在生成的页面中 会乱码
			// 获取或创建一个模版。
			Template template = configuration.getTemplate("template.html");
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("description", "我正在学习使用Freemarker生成静态文件！");

			List<String> nameList = new ArrayList<String>();
			nameList.add("陈靖仇");
			nameList.add("玉儿");
			nameList.add("宇文拓");
			paramMap.put("nameList", nameList);

			Map<String, Object> weaponMap = new HashMap<String, Object>();
			weaponMap.put("first", "轩辕剑");
			weaponMap.put("second", "崆峒印");
			weaponMap.put("third", "女娲石");
			weaponMap.put("fourth", "神农鼎");
			weaponMap.put("fifth", "伏羲琴");
			weaponMap.put("sixth", "昆仑镜");
			weaponMap.put("seventh", null);
			paramMap.put("weaponMap", weaponMap);

			Writer writer = new OutputStreamWriter(new FileOutputStream("success.html"), "UTF-8");
			template.process(paramMap, writer);

			System.out.println("恭喜，生成成功~~");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
}
