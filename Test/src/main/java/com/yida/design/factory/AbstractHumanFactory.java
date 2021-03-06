package com.yida.design.factory;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年4月20日 下午12:07:36
 ***********************
 */
public abstract class AbstractHumanFactory {
	public abstract <T extends Human> T createHuman(Class<T> c);
}
