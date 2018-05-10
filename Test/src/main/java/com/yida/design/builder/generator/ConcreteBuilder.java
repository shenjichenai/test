package com.yida.design.builder.generator;

/**
 *********************
 * 具体的建造者
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:09:45
 ***********************
 */
public class ConcreteBuilder extends Builder {

	private Product product = new Product();

	@Override
	public void setPart() {
		// 产品内的逻辑处理
	}

	@Override
	public Product builderProduct() {
		return product;
	}

}
