package com.yida.design.prototype.demo;

import com.yida.design.prototype.pojo.Mail;
import com.yida.utils.StringUtils;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月11日 下午3:21:40
 ***********************
 */
public class Client {
	// 数据库获取
	private static int MAX = 6;

	public static void main(String[] args) {
		int i = 0;
		Mail mail = new Mail(new AdvTemplate());
		mail.setTail("XX银行版权所有");
		while (i < MAX) {
			// 这里客隆对象，比新建一个对象效率更快，切满足高并发的线程安全
			Mail clone = mail.clone();
			// 以下是每封邮件不同的地方
			clone.setAppellation(StringUtils.getBaseRandString(5) + " 先生（女士）");
			clone.setReceiver(StringUtils.getBaseRandString(8) + "@" + StringUtils.getBaseRandString(5) + ".com");
			// 然后发送邮件"
			sendMail(clone);
			i++;
		}
	}

	// 发送邮件
	public static void sendMail(Mail mail) {
		System.out.println("标题：" + mail.getSubject() + "\t收件人：" + mail.getReceiver() + "\t...发送成功！");
	}

}
