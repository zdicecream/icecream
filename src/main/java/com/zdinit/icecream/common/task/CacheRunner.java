package com.zdinit.icecream.common.task;

//import com.zdinit.icecream.sys.entity.TDictionary;
//import com.zdinit.icecream.sys.service.ITDictionaryService;
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
/*        CdRunstate runstate = runstateService.getOne(null);
        redisUtil.set("bankname",runstate.getRsBankname());
        redisUtil.set("apid",runstate.getRsApid());
        redisUtil.set("loginstate",runstate.getRsLogonstate());
        redisUtil.set("date",runstate.getRsCurdate().toString());
        redisUtil.set("state",runstate.getRsSysstate());*/
    }
}
