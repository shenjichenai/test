package com.yida.quartz;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *********************
 * @author yangke
 * @version 1.0
 * @created 2018年5月24日 上午11:32:52
 ***********************
 */
public class Test {
	private static Logger _log = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {
		try {
			// Grab the Scheduler instance from the Factory
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

			JobDetail jb = JobBuilder.newJob(HelloJob.class)// .withDescription("this
															// is a ram job") //
															// job的描述
					// .withIdentity("hellowJob", "hellowGroup") // job
					// 的name和group
					.build();

			long time = System.currentTimeMillis() + 3 * 1000L; // 3秒后启动任务
			Date statTime = new Date(time);

			Trigger t = TriggerBuilder.newTrigger().withDescription("")
					// .withIdentity("hellowTrigger", "hellowTriggerGroup")
					// .withSchedule(SimpleScheduleBuilder.simpleSchedule())
					.startAt(statTime) // 默认当前时间启动
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0 17 * * ?")) // 每天17点触发
					.build();

			scheduler.scheduleJob(jb, t);

			// and start it off
			scheduler.start();
			_log.info("启动时间 ： " + new Date());
			_log.info("触发时间：" + t.getNextFireTime());
			// scheduler.shutdown();

		} catch (SchedulerException se) {
			se.printStackTrace();
		}
	}
}
