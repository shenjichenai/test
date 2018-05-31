package com.yida.jdk8.lambda;

import java.io.File;
import java.io.FileFilter;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月30日 下午2:29:02
 ***********************
 */
public class Hello {
	interface HelloService {
		String hello(String firstname, String lastname);
	}

	public static void main(String[] args) {

		HelloService helloService = (String firstname, String lastname) -> {

			String hello = "Hello " + firstname + " " + lastname;
			return hello;
		};
		// System.out.println(helloService.hello(args[0], "aa"));
		System.out.println(helloService.hello(args[0], args[1]));

		FileFilter fileFilter = (f) -> {
			String extension = null;
			String s = f.getName();
			int i = s.lastIndexOf('.');

			if (i > 0 && i < s.length() - 1) {
				extension = s.substring(i + 1).toLowerCase();
			}
			if (extension != null) {
				if (extension.equals("tiff") || extension.equals("tif") || extension.equals("gif")
						|| extension.equals("jpeg") || extension.equals("jpg") || extension.equals("png")
						|| extension.equals("bmp")) {
					return true;
				} else {
					return false;
				}
			}
			return false;
		};

		File file = new File("C:/JDK8/Figure10.bmp");
		System.out.println("File is an image file: " + fileFilter.accept(file));

	}
}
