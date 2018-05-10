package com.yida.design.builder.demo.builder;

import java.util.List;

import com.yida.design.builder.demo.car.CarModel;

/**
 *********************
 * 汽车建造者
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:21:58
 ***********************
 */
public abstract class CarBuilder {
	// 设置零件组合顺序
	public abstract void setSequence(List<String> sequence);

	// 顺序设置完毕，得到该车模型
	public abstract CarModel getCarModel();
}
