package com.yida.design.builder.generator;

/**
 *********************
 * 抽象建造者
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:04:44
 ***********************
 */
public abstract class Builder {
	// 设置产品的不同部分，以满足产品的不同需求
	public abstract void setPart();

	// 建造产品
	public abstract Product builderProduct();
}
