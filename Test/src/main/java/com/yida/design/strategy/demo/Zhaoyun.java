package com.yida.design.strategy.demo;

import com.yida.design.strategy.demo.strategy.BackDoor;
import com.yida.design.strategy.demo.strategy.BlockEnemy;
import com.yida.design.strategy.demo.strategy.GivenGreenLight;

/**
 *********************
 * 使用策略
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月12日 下午4:19:56
 ***********************
 */
public class Zhaoyun {
	public static void main(String[] args) {
		Context context;
		System.out.println("---刚刚到吴国的时候拆第一个---");
		context = new Context(new BackDoor());
		context.operate();
		System.out.println("\n\n\n\n\n\n\n\n");
		System.out.println("---刘备乐不思蜀了，拆第二个了---");
		context = new Context(new GivenGreenLight());
		context.operate();
		System.out.println("\n\n\n\n\n\n\n\n");
		System.out.println("---孙权的小兵追来了，咋办？拆第三个---");
		context = new Context(new BlockEnemy());
		context.operate();
	}
}
