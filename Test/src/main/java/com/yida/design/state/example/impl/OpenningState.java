package com.yida.design.state.example.impl;

import com.yida.design.state.example.Context;
import com.yida.design.state.example.LiftState;;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年8月9日 下午5:34:28
 ***********************
 */
public class OpenningState extends LiftState {

	// 开启当然可以关闭了，我就想测试一下电梯门开关功能
	@Override
	public void close() {
		// 状态修改
		super.context.setLiftState(Context.closeingState);
		// 动作委托为CloseState来执行
		super.context.getLiftState().close();
	}

	// 打开电梯门
	@Override
	public void open() {
		System.out.println("电梯门开启...");
	}

	// 门开着时电梯就运行跑，这电梯，吓死你！
	@Override
	public void run() {
		// do nothing;
		System.out.println("门开着时电梯就运行跑，这电梯，吓死你！");
	}

	// 开门还不停止？
	@Override
	public void stop() {
		// do nothing;
	}

}
