package com.yida.design.builder.demo.builder;

import java.util.List;

import com.yida.design.builder.demo.car.BMWModel;
import com.yida.design.builder.demo.car.CarModel;

/**
 *********************
 * 宝马建造者
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:48:04
 ***********************
 */
public class BMWBuilder extends CarBuilder {

	private BMWModel bmwModel = new BMWModel();

	@Override
	public void setSequence(List<String> sequence) {
		this.bmwModel.setSequence(sequence);
	}

	@Override
	public CarModel getCarModel() {
		return this.bmwModel;
	}

}
