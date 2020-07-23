package com.zdinit.icecream.config;


import com.zdinit.icecream.common.task.WeCatTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 整合Quartz ，默认多线程执行
 *
 * springboot自带 springTask 也是一种实现方式，但是不能持久化，暂不确定使用哪个
 */
@Configuration
public class QuartzConfig {

    /* 任务 */
    private static final String MAIL_TASK = "MailTask";
    private static final String WECAT_TASK = "WeCatTask";
    private static final String SMS_TASK = "SMSTask";

    /* 任务组 */
    private static final String MSG_GROUP = "MsgGroup";

    /* 触发器 */
    private static final String TRIGGER = "MsgGroup";

    /**
     * SimpleSchedule  每隔一段时间运行, 好像不能同时用，弃用
     */
//    @Bean
//    public JobDetail jobDetail(){
//        return JobBuilder.newJob(MailTask.class).withIdentity(MAIL_TASK).storeDurably().build();
//    }
//    @Bean
//    public Trigger trigger(){
//        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(10)  //时间
//                .repeatForever();
//        return TriggerBuilder.newTrigger().forJob(jobDetail()).withIdentity(MAIL_TASK).withSchedule(simpleScheduleBuilder).build();
//    }


    /**
     * CronSchedule Cron格式 ，指定时间格式
     */
    public void scheduleJobs() throws SchedulerException {
        Scheduler scheduler = scheduler();
        JobDetail jobDetail = JobBuilder.newJob(WeCatTask.class).withIdentity(WECAT_TASK,MSG_GROUP).build();
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 18 * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(TRIGGER,MSG_GROUP).withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
    }
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setOverwriteExistingJobs(true);//覆盖已存在的任务
        schedulerFactoryBean.setStartupDelay(60);//延时60秒启动定时任务，避免系统未完全启动却开始执行定时任务的情况
        return schedulerFactoryBean;
    }

    // 创建schedule
    @Bean(name = "scheduler")
    public Scheduler scheduler() {
        return schedulerFactoryBean().getScheduler();
    }
}
