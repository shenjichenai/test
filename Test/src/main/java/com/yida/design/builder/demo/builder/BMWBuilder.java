package com.yida.design.builder.demo.builder;

import java.util.List;

import com.yida.design.builder.demo.car.AbstractCarModel;
import com.yida.design.builder.demo.car.BMWModel;

/**
 *********************
 * 宝马建造者
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:48:04
 ***********************
 */
public class BMWBuilder extends AbstractCarBuilder {

	private BMWModel bmwModel = new BMWModel();

	@Override
	public void setSequence(List<String> sequence) {
		this.bmwModel.setSequence(sequence);
	}

	@Override
	public AbstractCarModel getCarModel() {
		return this.bmwModel;
	}

}
