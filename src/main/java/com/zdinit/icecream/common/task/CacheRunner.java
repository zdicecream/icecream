package com.zdinit.icecream.common.task;


import com.zdinit.icecream.draft.runstate.service.ICdRunstateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@Slf4j
public class CacheRunner implements CommandLineRunner {
    @Autowired
    private ICdRunstateService runstateService;

    @Override
    public void run(String... args) throws Exception {

    }
}
