package com.yida.design.responsibility.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.yida.design.responsibility.demo.handler.Father;
import com.yida.design.responsibility.demo.handler.Handler;
import com.yida.design.responsibility.demo.handler.Husband;
import com.yida.design.responsibility.demo.handler.Son;
import com.yida.design.responsibility.demo.women.IWomen;
import com.yida.design.responsibility.demo.women.Women;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午3:09:36
 ***********************
 */
public class Client {
	public static void main(String[] args) {
		Random random = new Random();
		// 抓取随机妇女
		List<IWomen> list = new ArrayList<IWomen>();
		for (int i = 0; i < 5; i++) {
			list.add(new Women(random.nextInt(4), "我要出去逛街"));
		}
		// 定义三个请示对象
		Handler father = new Father();
		Handler husband = new Husband();
		Handler son = new Son();
		// 设置请求顺序
		father.setNextHandler(husband);
		husband.setNextHandler(son);
		for (IWomen women : list) {
			father.handlerMassage(women);
		}
	}
}
