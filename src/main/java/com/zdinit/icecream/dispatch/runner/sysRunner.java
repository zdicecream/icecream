package com.zdinit.icecream.dispatch.runner;

import com.zdinit.icecream.auth.entity.Runstate;
import com.zdinit.icecream.auth.service.IRunstateService;
import com.zdinit.icecream.common.CommonValue;
import com.zdinit.icecream.common.exception.RunstateNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@Slf4j
public class sysRunner implements CommandLineRunner {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IRunstateService runstateService;

    @Override
    public void run(String... args) throws Exception {

        Runstate runstate = runstateService.getOne(null);
        if (runstate == null) {
            throw new RunstateNotFoundException("系统状态数据缺失！");
        }
        redisTemplate.opsForHash().put(CommonValue.SYSTEM,"sysDate",runstate.getSysdate());
        redisTemplate.opsForHash().put(CommonValue.SYSTEM,"sysState",runstate.getSysstate());
    }
}
