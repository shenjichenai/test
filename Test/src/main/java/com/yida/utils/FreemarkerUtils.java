package com.yida.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.entity.annotation.Comment;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年9月15日 下午4:08:59
 ***********************
 */
public class FreemarkerUtils {
	@SuppressWarnings("rawtypes")
	public static void createDatagridFileWithEntity(String templatePath, String targetPath, Class entity) {
		Map<String, Object> paramMap = getParamMapWithPojo(entity);
		createFile(templatePath, targetPath, paramMap);
	}

	public static void createFile(String templatePath, String targetPath, Map<String, Object> paramMap) {
		Template template = getTemplate(templatePath);
		try {
			Writer writer = new OutputStreamWriter(new FileOutputStream(new File(targetPath)), "UTF-8");

			template.process(paramMap, writer);
			String s = "bb";
			new String(s.getBytes(), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

	private static Template getTemplate(String templatePath) {
		File file = new File(templatePath);
		String name = file.getName();
		File parentFile = file.getParentFile();
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		try {
			cfg.setDirectoryForTemplateLoading(parentFile);
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			Template template = cfg.getTemplate(name);
			return template;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	private static Map<String, Object> getParamMapWithPojo(Class clazz) {
		List<Class> classes = new ArrayList<>();
		getClasses(clazz, classes);
		List<Map<String, Object>> list = new ArrayList<>();
		for (Class class1 : classes) {
			Field[] fields = class1.getDeclaredFields();
			for (Field field : fields) {
				field.isAccessible();
				String name = field.getName();
				Id id = field.getAnnotation(Id.class);
				boolean idField = false;
				String value = null;
				if (id == null) {
					Name namePk = field.getAnnotation(Name.class);
					if (namePk != null) {
						idField = true;
					}
				} else {
					idField = true;
				}
				Comment comment = field.getAnnotation(Comment.class);
				if (comment != null) {
					value = comment.value();
				}
				Map<String, Object> map = new HashMap<>();
				map.put("idField", idField);
				map.put("comment", value);
				map.put("name", name);
				list.add(map);
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("fields", list);
		return map;
	}

	@SuppressWarnings("rawtypes")
	private static void getClasses(Class clazz, List<Class> classes) {
		if (clazz != Object.class) {
			classes.add(clazz);
			Class superclass = clazz.getSuperclass();
			getClasses(superclass, classes);
		}
	}
}
