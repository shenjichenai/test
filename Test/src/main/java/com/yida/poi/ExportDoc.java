package com.yida.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yida.utils.DateUtils;
import com.yida.utils.StringUtils;

/**
 * 传参的方式可以更优美，时间有了再更新
 * 
 * @author 0
 *
 */
public class ExportDoc {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExportDoc.class);
	// 文本
	public static final Pattern PATTERN_REG_TXT = Pattern.compile("\\{Txt%(.*?)%Txt\\}");
	// 图片
	public static final Pattern PATTERN_REG_PIC = Pattern.compile("\\{Pic%(.*?)%Pic\\}");
	// 表格
	public static final Pattern PATTERN_REG_TAB = Pattern.compile("\\{Tab%(.*?)%Tab\\}");
	// 列
	public static final Pattern PATTERN_REG_COL = Pattern.compile("\\{Col%(.*?)%Col\\}");

	/*
	 * 替换模版内容
	 * 
	 * @param templatePath 模板路径
	 * 
	 * @param tempPath 缓存路径
	 * 
	 * @param contentMap key:标识符; value：替换数据
	 */
	public void replaceContent(String templatePath, String tempPath, Map<String, Object> contentMap)
			throws IOException {
		FileInputStream in = new FileInputStream(new File(templatePath));
		XWPFDocument xwpf = new XWPFDocument(in);
		try {
			for (Map.Entry<String, Object> entry : contentMap.entrySet()) {
				/*
				 * key {Txt%Text%Txt} {Pic%Picture%Pic} {Tab%table%Tab}
				 */
				String key = entry.getKey();
				Matcher textMatcher = PATTERN_REG_TXT.matcher(key);
				Matcher picMatcher = PATTERN_REG_PIC.matcher(key);
				Matcher tabMatcher = PATTERN_REG_TAB.matcher(key);
				if (textMatcher.find()) {
					replaceText(xwpf, entry);
				}
				if (picMatcher.find()) {
					replacePic(xwpf, entry);
				}
				if (tabMatcher.find()) {
					replaceTable(xwpf, entry);
				}
			}

			FileOutputStream out = new FileOutputStream(tempPath);
			try {
				xwpf.write(out);
			} finally {
				xwpf.close();
			}
		} catch (Exception e) {
			LOGGER.error("Word文档生成出错：", e);
			throw e;
		} finally {
			xwpf.close();
		}
	}

	@SuppressWarnings({ "unchecked" })
	private void replaceTable(XWPFDocument doc, Entry<String, Object> entry) {
		List<XWPFTable> tables = doc.getTables();
		List<Map<String, Object>> records = null;
		for (XWPFTable table : tables) {
			List<XWPFTableRow> rows = table.getRows();
			int rowCount = rows.size();
			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
				// 表名配置信息
				String cellContent = rows.get(rowIndex).getCell(0).getText();
				Matcher matcher = PATTERN_REG_TAB.matcher(cellContent);
				if (matcher.find()) {
					String k = entry.getKey();
					if (k.equals(cellContent)) {
						records = (List<Map<String, Object>>) entry.getValue();
						// 列配置信息
						if (rowIndex + 1 < rowCount) {
							XWPFTableRow xwpfTableRow = rows.get(rowIndex + 1);

							List<XWPFTableCell> tableCells = xwpfTableRow.getTableCells();
							int colCount = tableCells.size();

							CTTcPr[] tcPrs = new CTTcPr[colCount];
							String[] colNames = new String[colCount];
							CTPPr[] pPrs = new CTPPr[colCount];
							CTRPr[] rPrs = new CTRPr[colCount];

							for (int colIndex = 0; colIndex < colCount; colIndex++) {

								XWPFTableCell xwpfTableCell = tableCells.get(colIndex);
								XWPFParagraph paragraph = xwpfTableCell.getParagraphs().get(0);
								String text = paragraph.getText();

								Matcher mCol = PATTERN_REG_COL.matcher(text);
								if (mCol.find()) {
									String colName = mCol.group(1).trim();

									tcPrs[colIndex] = xwpfTableCell.getCTTc().getTcPr();
									colNames[colIndex] = colName;
									pPrs[colIndex] = paragraph.getCTP().getPPr();
									XWPFRun xwpfRun = paragraph.getRuns().get(0);
									rPrs[colIndex] = xwpfRun.getCTR().getRPr();
								}
							}
							for (int i = 0; i < records.size(); i++) {
								Map<String, Object> map1 = records.get(i);
								XWPFTableRow newRow = table.createRow();
								for (int j = 0; j < colNames.length; j++) {
									String key = colNames[j];
									if (StringUtils.isEmpty(key)) {
										continue;
									}
									String value = map1.get(key) == null ? "" : map1.get(key).toString();

									XWPFTableCell cell = newRow.getCell(j);
									cell.getCTTc().setTcPr(tcPrs[j]);

									XWPFParagraph newParagraph = cell.getParagraphs().get(0);
									newParagraph.getCTP().setPPr(pPrs[j]);

									XWPFRun createRun = newParagraph.createRun();
									createRun.getCTR().setRPr(rPrs[j]);
									createRun.setText(value);
								}
							}
						}
					}
					table.removeRow(rowIndex + 1);
					table.removeRow(rowIndex);
					break;
				}
			}
		}
	}

	/*
	 * 替换图片:获取段落所有文本，一次性替换内容，因为poi会出现分段落混乱的情况
	 */
	private void replacePic(XWPFDocument xwpf, Entry<String, Object> entry) {
		String replaceKey = null;
		Iterator<XWPFParagraph> itPara = xwpf.getParagraphsIterator();
		try {
			while (itPara.hasNext()) {
				XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
				List<XWPFRun> runs = paragraph.getRuns();
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < runs.size(); i++) {
					XWPFRun run = runs.get(i);
					int pos = run.getTextPosition();
					sb.append(run.getText(pos));
				}
				replaceKey = entry.getKey();
				String str = sb.toString();
				boolean contains = str.contains(replaceKey);
				if (contains) {
					for (int i = 0; i < runs.size(); i++) {
						XWPFRun run = runs.get(i);
						run.setText("", 0);
					}
					String regex = StringUtils.string2RegExp(replaceKey);
					String[] split = str.replaceAll(regex, "," + regex + ",").split(",");
					for (int i = 0; i < split.length; i++) {
						String string = split[i];
						if (!StringUtils.isEmpty(split[i])) {
							if (string.equals(replaceKey)) {
								String imgPath = entry.getValue().toString();
								int format = getImgFormat(imgPath);
								paragraph.createRun().addPicture(new FileInputStream(imgPath), format, imgPath,
										Units.toEMU(415), Units.toEMU(253));
							} else {
								paragraph.createRun().setText(split[i]);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取图片格式
	 * 
	 * @param imgFile
	 * @return
	 */
	private int getImgFormat(String imgFile) {
		int format;

		if (imgFile.endsWith(".emf")) {
			format = XWPFDocument.PICTURE_TYPE_EMF;
		} else if (imgFile.endsWith(".wmf")) {
			format = XWPFDocument.PICTURE_TYPE_WMF;
		} else if (imgFile.endsWith(".pict")) {
			format = XWPFDocument.PICTURE_TYPE_PICT;
		} else if (imgFile.endsWith(".jpeg") || imgFile.endsWith(".jpg")) {
			format = XWPFDocument.PICTURE_TYPE_JPEG;
		} else if (imgFile.endsWith(".png")) {
			format = XWPFDocument.PICTURE_TYPE_PNG;
		} else if (imgFile.endsWith(".dib")) {
			format = XWPFDocument.PICTURE_TYPE_DIB;
		} else if (imgFile.endsWith(".gif")) {
			format = XWPFDocument.PICTURE_TYPE_GIF;
		} else if (imgFile.endsWith(".tiff")) {
			format = XWPFDocument.PICTURE_TYPE_TIFF;
		} else if (imgFile.endsWith(".eps")) {
			format = XWPFDocument.PICTURE_TYPE_EPS;
		} else if (imgFile.endsWith(".bmp")) {
			format = XWPFDocument.PICTURE_TYPE_BMP;
		} else if (imgFile.endsWith(".wpg")) {
			format = XWPFDocument.PICTURE_TYPE_WPG;
		} else {
			throw new RuntimeException("不支持的图片格式。");
		}
		return format;
	}

	/*
	 * 替换文本内容：获取段落所有文本，一次性替换内容，因为poi会出现分段落混乱的情况
	 */
	private void replaceText(XWPFDocument xwpf, Entry<String, Object> entry) {
		String replaceKey = null;
		Iterator<XWPFParagraph> itPara = xwpf.getParagraphsIterator();
		try {
			replaceKey = entry.getKey();
			while (itPara.hasNext()) {
				XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
				List<XWPFRun> runs = paragraph.getRuns();
				StringBuilder sb = new StringBuilder();

				for (int i = 0; i < runs.size(); i++) {
					XWPFRun run = runs.get(i);
					int pos = run.getTextPosition();
					sb.append(run.getText(pos));
				}

				String str = sb.toString();
				boolean contains = str.contains(replaceKey);
				if (contains) {
					for (int i = 0; i < runs.size(); i++) {
						XWPFRun run = runs.get(i);
						run.setText("", 0);
					}
					String regex = StringUtils.string2RegExp(replaceKey);
					String replaceAll = sb.toString().replaceAll(regex, entry.getValue().toString());
					if (runs.size() > 0) {
						runs.get(0).setText(replaceAll);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.error("Word文档生成出错：", e);
			throw e;
		}

	}

	public static void main(String[] args) {
		String ss = "这是一整{Txt%Text%Txt}";
		String aa = "{Txt%Text%Txt}";
		System.out.println(ss.contains(aa));
	}

	/*
	 * 通过字段类型控制数据输出格式
	 * 
	 * @param dataset 数据集
	 * 
	 * @param headers 需要设置的字段集合
	 * 
	 * @return
	 */
	public List<Map<String, Object>> setDataFormatByFieldType(List<Map<String, Object>> dataset,
			List<Map<String, String>> headers) {
		for (Map<String, Object> dataMap : dataset) {
			for (Map<String, String> typeMap : headers) {
				String field = typeMap.get("field");
				String fieldType = typeMap.get("fieldType");
				String value = dataMap.get(field) == null ? "" : dataMap.get(field).toString();
				if ("number".equals(fieldType)) {// 数字类型
					if ("".equals(value)) {
						value = "0";
					}
					dataMap.put(field, value);
				} else if ("isThrough".equals(fieldType)) {// 状态码转描述
					if ("0".equals(value)) {
						value = "不可通行";
					} else if ("1".equals(value)) {
						value = "可通行";
					}
					dataMap.put(field, value);
				} else if ("date".equals(fieldType)) {// 无时分秒的日期格式
					value = DateUtils.formatDate(new Date(Long.valueOf(value)), DateUtils.DATE_FORMAT);
					dataMap.put(field, value);
				} else if ("datetime".equals(fieldType)) {// 包涵时分秒的日期格式
					value = DateUtils.formatDate(new Date(Long.valueOf(value)), DateUtils.DATE_TIME24_FORMAT);
					dataMap.put(field, value);
				}
			}
		}
		return dataset;
	}
}
