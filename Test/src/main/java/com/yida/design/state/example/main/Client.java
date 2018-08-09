package com.yida.design.state.example.main;

import com.yida.design.state.example.Context;
import com.yida.design.state.example.impl.ClosingState;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年8月9日 下午5:43:59
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		Context context = new Context();
		context.setLiftState(new ClosingState());
		context.open();
		context.close();
		context.run();
		context.stop();
	}
}
