package com.yida.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yida.websocket.tomcat.WorkFlow;

/**
 *********************
 * @author yk
 * @version 1.0
 * @created 2018年5月29日18:07:36
 ***********************
 */
@WebListener
public class StartListener implements ServletContextListener {
	private static final Logger LOG = LoggerFactory.getLogger(StartListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOG.info("初始化配置信息。。。");
		loadConfig(sce);

		WorkFlow workFlow = new WorkFlow();
		new Thread(workFlow).start();

	}

	private void loadConfig(ServletContextEvent sce) {
		System.out.println(111);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("*************************关闭平台************************************");
	}

}
