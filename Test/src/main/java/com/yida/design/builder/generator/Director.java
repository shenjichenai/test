package com.yida.design.builder.generator;

/**
 *********************
 * 导演类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:13:14
 ***********************
 */
public class Director {

	private AbstractBuilder builder = new ConcreteBuilder();

	public Product getAProduct() {
		// 设置产品内部生产逻辑
		builder.setPart();
		return builder.builderProduct();
	}
}
