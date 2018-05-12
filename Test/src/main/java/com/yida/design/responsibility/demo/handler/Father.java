package com.yida.design.responsibility.demo.handler;

import com.yida.design.responsibility.demo.women.IWomen;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午3:01:10
 ***********************
 */
public class Father extends Handler {

	public Father() {
		super(Handler.FATHER_LEVEL_REQUEST);
	}

	@Override
	protected void response(IWomen women) {
		System.out.println("--------女儿向父亲请示-------");
		System.out.println(women.getRequest());
		System.out.println("父亲的答复是:同意\n");
	}

}
