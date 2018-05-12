package com.yida.design.responsibility.demo.handler;

import com.yida.design.responsibility.demo.women.IWomen;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午2:36:35
 ***********************
 */
public abstract class Handler {
	public final static int FATHER_LEVEL_REQUEST = 1;
	public final static int HUSBAND_LEVEL_REQUEST = 2;
	public final static int SON_LEVEL_REQUEST = 3;
	// 能处理的级别
	private int lavel = 0;
	// 下一个责任人
	private Handler nextHandler;

	// 类本生的处理级别
	public Handler(int lavel) {
		this.lavel = lavel;
	}

	public final void handlerMassage(IWomen women) {
		if (women.getType() == this.lavel) {
			this.response(women);
		} else {
			// 有接盘侠
			if (this.nextHandler != null) {
				this.nextHandler.handlerMassage(women);
			} else {
				// 无接盘侠，默认不同意
				System.out.println("------不同意------");
			}
		}
	}

	// 设置下一个接盘侠
	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	// 回应请求
	protected abstract void response(IWomen women);

}
