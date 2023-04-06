package com.zdinit.icecream;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class AsynTaskService{
    @Async
    public void f1(){
        for (int i = 0; i <10 ; i++) {
            log.info("this is {}",Thread.currentThread().getId());

        }
    }
    @Async
    public void f2(){
        for (int i = 0; i <10 ; i++) {
            log.info("this is {}",Thread.currentThread().getId());
        }
    }
}
