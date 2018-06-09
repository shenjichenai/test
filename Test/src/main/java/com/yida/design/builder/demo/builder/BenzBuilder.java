package com.yida.design.builder.demo.builder;

import java.util.List;

import com.yida.design.builder.demo.car.AbstractCarModel;
import com.yida.design.builder.demo.car.BenzModel;

/**
 *********************
 * 奔驰建造者
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:39:11
 ***********************
 */
public class BenzBuilder extends AbstractCarBuilder {

	private BenzModel benzModel = new BenzModel();

	@Override
	public void setSequence(List<String> sequence) {
		this.benzModel.setSequence(sequence);
	}

	@Override
	public AbstractCarModel getCarModel() {
		return this.benzModel;
	}

}
