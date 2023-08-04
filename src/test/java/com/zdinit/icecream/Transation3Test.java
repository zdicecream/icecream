package com.zdinit.icecream;

import com.zdinit.icecream.auth.entity.Runstate;
import com.zdinit.icecream.auth.entity.User;
import com.zdinit.icecream.auth.service.IRunstateService;
import com.zdinit.icecream.auth.service.IUserService;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class Transation3Test {
    @Autowired
    private IRunstateService runstateService;
    public void server3(){
        Runstate runstate = new Runstate();
        runstate.setId(33L);
        runstateService.save(runstate);
    }
}
