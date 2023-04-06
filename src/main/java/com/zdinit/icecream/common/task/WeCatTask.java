package com.zdinit.icecream.common.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 定时任务
 */
@Component
@Slf4j
public class WeCatTask extends QuartzJobBean {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//       redisTemplate.opsForValue().set("data","TaskTest",3000l, TimeUnit.SECONDS);
//       log.info(redisTemplate.opsForValue().get("data").toString());



//        redisTemplate.opsForHash().put("day", "01", "01");
//        redisTemplate.opsForHash().put("day", "02", "02");
//        redisTemplate.opsForHash().put("day", "03", "03");
//        log.info((String) redisTemplate.opsForHash().get("day","01"));
//
//        redisTemplate.opsForList().rightPush("eeecolor","red");
//        redisTemplate.opsForList().rightPush("eeecolor","blue");
//        redisTemplate.opsForList().rightPush("eeecolor","yello");
//        redisTemplate.opsForList().rightPush("eeecolor","dark");
//        redisTemplate.opsForList().rightPush("eeecolor","green");
//        log.info((String) redisTemplate.opsForList().rightPop("eeecolor"));
//        log.info(String.valueOf(redisTemplate.opsForList().range("eeecolor",0,3)));

//        redisTemplate.opsForSet().add("xiaohong","a","b","v","d");
//        redisTemplate.opsForSet().add("msg_001","a","e","v","d");
//        redisTemplate.opsForSet().add("msg_002","a","e","v","d");
//        redisTemplate.opsForSet().add("msg_003","a","e","v","d");
//        redisTemplate.opsForSet().add("msg_004","a","e","v","d");
        redisTemplate.opsForValue().set("qwer","222",10, TimeUnit.SECONDS);




    }
}
