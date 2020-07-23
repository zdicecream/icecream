package com.zdinit.icecream.common.task;

import com.zdinit.icecream.common.utils.RedisUtil;
import com.zdinit.icecream.sys.entity.TDictionary;
import com.zdinit.icecream.sys.service.ITDictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 定时任务
 */
@Component
@Slf4j
public class WeCatTask extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("TaskTest");


    }
}
