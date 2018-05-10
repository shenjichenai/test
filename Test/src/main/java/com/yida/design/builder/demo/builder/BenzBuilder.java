package com.yida.design.builder.demo.builder;

import java.util.List;

import com.yida.design.builder.demo.car.BenzModel;
import com.yida.design.builder.demo.car.CarModel;

/**
 *********************
 * 奔驰建造者
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:39:11
 ***********************
 */
public class BenzBuilder extends CarBuilder {

	private BenzModel benzModel = new BenzModel();

	@Override
	public void setSequence(List<String> sequence) {
		this.benzModel.setSequence(sequence);
	}

	@Override
	public CarModel getCarModel() {
		return this.benzModel;
	}

}
