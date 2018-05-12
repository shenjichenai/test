package com.yida.design.responsibility.demo.handler;

import com.yida.design.responsibility.demo.women.IWomen;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午3:03:29
 ***********************
 */
public class Son extends Handler {

	public Son() {
		super(Handler.SON_LEVEL_REQUEST);
	}

	@Override
	protected void response(IWomen women) {
		System.out.println("--------母亲向儿子请示-------");
		System.out.println(women.getRequest());
		System.out.println("儿子的答复是：同意\n");
	}

}
