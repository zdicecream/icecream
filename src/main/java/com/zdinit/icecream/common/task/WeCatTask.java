package com.zdinit.icecream.common.task;

import com.zdinit.icecream.draft.runstate.entity.CdRunstate;
import com.zdinit.icecream.draft.runstate.service.ICdRunstateService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 */
@Component
@Slf4j
public class WeCatTask extends QuartzJobBean {
    @Autowired
    private ICdRunstateService runstateService;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
/*        log.info("TaskTest");
        CdRunstate runstate = runstateService.getOne(null);
        if (runstate != null && !runstate.getWorkDate().equals(runstate.getRsCurdate())) {
            runstate.setWorkDate(runstate.getRsCurdate());
            runstateService.saveOrUpdate(runstate);
        }*/
    }
}
