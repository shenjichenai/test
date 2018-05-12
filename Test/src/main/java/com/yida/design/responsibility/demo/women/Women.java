package com.yida.design.responsibility.demo.women;

/**
 *********************
 * 具体的妇女类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午2:46:29
 ***********************
 */
public class Women implements IWomen {

	/**
	 * 通过一个int类型的参数来描述妇女的个人状况 1--未出嫁 2--出嫁 3--夫死
	 */
	private int type;
	/**
	 * 构造器传过来的请求
	 */
	private String request;

	public Women(int type, String request) {
		this.type = type;
		this.request = request;
		// 为了便于显示，在这里做了点处理
		switch (this.type) {
		case 1:
			this.request = "女儿的请求是：" + request;
			break;
		case 2:
			this.request = "妻子的请求是：" + request;
			break;
		case 3:
			this.request = "母亲的请求是：" + request;
		}
	}

	public int getType() {
		return this.type;
	}

	public String getRequest() {
		return this.request;
	}

}
