package com.yida.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.yida.utils.FileUtils;

/**
 *********************
 * 兼容2003和2007
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年7月6日 下午5:30:34
 ***********************
 */
public class Word2Html {

	private static Logger LOG = LoggerFactory.getLogger(Word2Html.class);

	private static String IMG_SUB_DIR = "image";

	public static void word2Html(String sourcePath, String targetPath) {
		String fileExtensionName = FileUtils.getFileExtension(new File(sourcePath)).toLowerCase();
		File targetFile = new File(targetPath);
		String parentPath = targetFile.getParent();
		String imagePathStr = parentPath + File.separator + IMG_SUB_DIR + File.separator;
		switch (fileExtensionName) {
		case ".doc":
			doc2003ToHtml(sourcePath, targetPath, imagePathStr);
			break;
		case ".docx":
			doc2007ToHtml(sourcePath, targetPath, imagePathStr);
			break;
		default:
			throw new RuntimeException("未知的文件类型！");
		}
	}

	public static void doc2003ToHtml(String sourceFileName, String targetFileName, String imagePathStr) {
		HWPFDocument wordDocument;
		try {
			wordDocument = new HWPFDocument(new FileInputStream(sourceFileName));
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
			WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(document);
			// 保存图片，并返回图片的相对路径
			wordToHtmlConverter.setPicturesManager((content, pictureType, name, width, height) -> {
				try (FileOutputStream out = new FileOutputStream(imagePathStr + name)) {
					out.write(content);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return IMG_SUB_DIR + "/" + name;
			});
			wordToHtmlConverter.processDocument(wordDocument);
			Document htmlDocument = wordToHtmlConverter.getDocument();
			DOMSource domSource = new DOMSource(htmlDocument);
			StreamResult streamResult = new StreamResult(new File(targetFileName));

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer serializer = tf.newTransformer();
			serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			serializer.setOutputProperty(OutputKeys.METHOD, "html");
			serializer.transform(domSource, streamResult);
		} catch (Exception e) {
			LOG.error("", e);
			throw new RuntimeException(e);
		}

	}

	public static void doc2007ToHtml(String sourceFileName, String targetFileName, String imagePathStr) {
		XWPFDocument document;
		try (InputStream in = new FileInputStream(sourceFileName);
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetFileName),
						"utf-8");) {
			document = new XWPFDocument(in);
			XHTMLOptions options = XHTMLOptions.create();
			// 存放图片的文件夹
			options.setExtractor(new FileImageExtractor(new File(imagePathStr)));
			// html中图片的路径
			options.URIResolver(new BasicURIResolver("image"));
			XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
			xhtmlConverter.convert(document, outputStreamWriter, options);
		} catch (Exception e) {
			LOG.error("", e);
			throw new RuntimeException(e);
		}
	}
}
