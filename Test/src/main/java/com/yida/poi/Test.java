/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.poi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月28日 下午5:24:50
 ***********************
 */
public class Test {
	public static void main(String[] args) {
		ExportDoc exportDocService = new ExportDoc();
		List<Map<String, Object>> dataset = new ArrayList<>();// 数据库查询数据集

		for (int i = 0; i < 3; i++) {
			Map<String, Object> map = new HashMap<>();
			map.put("NAME", UUID.randomUUID());
			map.put("ROADNAME", UUID.randomUUID());
			map.put("STATE", UUID.randomUUID());
			map.put("REMARK", UUID.randomUUID());
			dataset.add(map);
		}

		List<Map<String, String>> headers = new ArrayList<>();// 字段类型
		if (null != headers && !headers.isEmpty()) {
			dataset = exportDocService.setDataFormatByFieldType(dataset, headers);// 通过字段类型规范数据输出
		}
		String templatePath = new File("src/main/resources/document/aaa.docx").getAbsolutePath();// 模板路径
		String imgPath = new File("src/main/resources/images/office_1.jpg").getAbsolutePath();// 图片路径
		String tempPath = "C:\\Users\\0\\Desktop\\temp\\doc\\bbb.docx";// 生成路径

		Map<String, Object> contentMap = new HashMap<String, Object>();

		contentMap.put("{Txt%Text%Txt}", "替换内容");
		contentMap.put("{Pic%Picture%Pic}", imgPath);
		contentMap.put("{Tab%table%Tab}", dataset);
		try {
			exportDocService.replaceContent(templatePath, tempPath, contentMap);
			System.out.println("success");
		} catch (IOException e) {
			e.printStackTrace();
		} // 替换模版内容
	}
}
