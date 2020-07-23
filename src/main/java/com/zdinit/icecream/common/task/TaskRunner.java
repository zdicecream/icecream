package com.zdinit.icecream.common.task;

import com.zdinit.icecream.config.QuartzConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 定时任务触发Runner
 */
@Component
@Order(1)
public class TaskRunner implements CommandLineRunner {
    @Autowired
    private QuartzConfig quartzConfig;
    @Override
    public void run(String... args) throws Exception {
        quartzConfig.scheduleJobs();
    }
}
