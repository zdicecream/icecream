package com.zdinit.icecream;

import com.zdinit.icecream.auth.entity.Runstate;
import com.zdinit.icecream.auth.entity.User;
import com.zdinit.icecream.auth.service.IRunstateService;
import com.zdinit.icecream.auth.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Transation2Test {
    @Autowired
    private IRunstateService runstateService;
    @Autowired
    private Transation3Test transation3Test;
    public void server2(){
        Runstate runstate = new Runstate();
        runstate.setId(22L);
        runstateService.save(runstate);

        transation3Test.server3();

    }
}
