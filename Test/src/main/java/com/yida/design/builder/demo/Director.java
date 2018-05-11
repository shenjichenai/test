package com.yida.design.builder.demo;

import java.util.ArrayList;
import java.util.List;

import com.yida.design.builder.demo.builder.BMWBuilder;
import com.yida.design.builder.demo.builder.BenzBuilder;
import com.yida.design.builder.demo.car.BMWModel;
import com.yida.design.builder.demo.car.BenzModel;

/**
 *********************
 * 导演类
 * 
 * @author yangke
 * @version 1.0
 * @created 2018年5月10日 下午5:50:49
 ***********************
 */
public class Director {
	// 并非线程安全
	private List<String> sequence = new ArrayList<String>();
	private BenzBuilder benzBuilder = new BenzBuilder();
	private BMWBuilder bmwBuilder = new BMWBuilder();

	public BenzModel getABenzModel() {
		// 清理场景，这里是一些初级程序员不注意的地方
		this.sequence.clear();
		// ABenzModel的执行顺序
		this.sequence.add("start");
		this.sequence.add("stop");
		this.benzBuilder.setSequence(this.sequence);
		return (BenzModel) this.benzBuilder.getCarModel();
	}

	public BMWModel getBBMWModel() {
		this.sequence.clear();
		this.sequence.add("alarm");
		this.sequence.add("start");
		this.sequence.add("stop");
		this.bmwBuilder.setSequence(this.sequence);
		return (BMWModel) this.bmwBuilder.getCarModel();
	}
}
