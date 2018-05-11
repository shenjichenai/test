/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.design.prototype.pojo;

import com.yida.design.prototype.demo.AdvTemplate;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月11日 下午3:18:52
 ***********************
 */
public class Mail implements Cloneable {
	// 收件人
	private String receiver;
	// 邮件名称
	private String subject;
	// 称谓
	private String appellation;
	// 邮件内容
	private String contxt;
	// 邮件的尾部，一般都是加上"XXX版权所有"等信息
	private String tail;

	public Mail(AdvTemplate advTemplate) {
		this.subject = advTemplate.getAdvSubject();
		this.contxt = advTemplate.getAdvContext();
	}

	@Override
	public Mail clone() {
		Mail mail = null;
		try {
			mail = (Mail) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return mail;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public String getContxt() {
		return contxt;
	}

	public void setContxt(String contxt) {
		this.contxt = contxt;
	}

	public String getTail() {
		return tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}

}
