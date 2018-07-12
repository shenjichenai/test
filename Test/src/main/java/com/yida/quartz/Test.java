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
	private static Logger log = LoggerFactory.getLogger(Test.class);

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


			Trigger t = TriggerBuilder.newTrigger().withDescription("")
					// .withIdentity("hellowTrigger", "hellowTriggerGroup")
					// .withSchedule(SimpleScheduleBuilder.simpleSchedule())
					.withSchedule(CronScheduleBuilder.cronSchedule("* 0/10 * * * ?")) // 每天17点触发
					//.startNow() // 默认当前时间启动
					.build();

			scheduler.scheduleJob(jb, t);

			// and start it off
			scheduler.start();
			log.info("启动时间 ： " + new Date());
			log.info("触发时间：" + t.getNextFireTime());
			// scheduler.shutdown();

		} catch (SchedulerException se) {
			se.printStackTrace();
		}
	}
}
