package com.yida.design.Facade.demo2;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年7月14日 下午5:24:18
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		// 现代化的邮局，有这项服务，邮局名称叫Hell Road
		ModenPostOffice2 hellRoadPostOffice = new ModenPostOffice2();
		// 你只要把信的内容和收信人地址给他，他会帮你完成一系列的工作
		// 定义一个地址
		String address = "Happy Road No. 666,God Province,Heaven";
		// 信的内容
		String context = "Hello,It's me,do you know who I am? I'm your old lover. //你给我发送吧";
		hellRoadPostOffice.sendLetter(context, address);
	}
}
