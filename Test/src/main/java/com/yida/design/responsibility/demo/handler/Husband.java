package com.yida.design.responsibility.demo.handler;

import com.yida.design.responsibility.demo.women.IWomen;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午3:02:36
 ***********************
 */
public class Husband extends Handler {

	public Husband() {
		super(Handler.HUSBAND_LEVEL_REQUEST);
	}

	@Override
	protected void response(IWomen women) {
		System.out.println("--------妻子向丈夫请示-------");
		System.out.println(women.getRequest());
		System.out.println("丈夫的答复是：同意\n");
	}

}
