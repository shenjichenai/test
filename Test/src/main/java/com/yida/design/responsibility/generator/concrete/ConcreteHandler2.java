package com.yida.design.responsibility.generator.concrete;

import com.yida.design.responsibility.generator.Handler;
import com.yida.design.responsibility.generator.Level;
import com.yida.design.responsibility.generator.Request;
import com.yida.design.responsibility.generator.Response;

/**
 *********************
 * 具体处理者
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午3:41:13
 ***********************
 */
public class ConcreteHandler2 extends Handler {

	@Override
	protected Level getHandlerLevel() {
		// 设置自己的处理级别
		return null;
	}

	@Override
	protected Response echo(Request request) {
		// 定义自己的处理逻辑
		return null;
	}

}
