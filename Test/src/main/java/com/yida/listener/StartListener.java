/**
 * Copyright  2010-2015 四川数码物联网络科技有限责任公司. All Rights Reserved.
 */
package com.yida.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *********************
 * @author wj
 * @version 1.0
 * @created 2018年4月11日 上午11:10:34
 ***********************
 */
public class StartListener implements ServletContextListener {
	private static final Logger LOG = LoggerFactory.getLogger(StartListener.class);

	public void contextInitialized(ServletContextEvent sce) {
		LOG.info("启动短信发布平台。。。");
		System.out.println("*************************启动短信发布平台***********************************");
		LOG.info("初始化配置信息。。。");
		loadConfig(sce);

	}

	private void loadConfig(ServletContextEvent sce) {
		System.out.println(111);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		LOG.info("短信发布平台正在退出。。。");
		System.out.println("*************************关闭短信发布平台************************************");
	}

}
