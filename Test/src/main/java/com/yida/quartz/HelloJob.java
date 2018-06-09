package com.yida.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月24日 下午12:03:19
 ***********************
 */
public class HelloJob implements Job {
	private static Logger log = LoggerFactory.getLogger(HelloJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("Hello World! - " + new Date());

	}

}
