package com.zdinit.icecream;

import com.zdinit.icecream.auth.entity.User;
import com.zdinit.icecream.auth.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Transation2Test {
    @Autowired
    private IUserService userService;
    @Autowired
    private Transation3Test transation3Test;
    @Transactional
    public void server2(){
        User user = new User();
        user.setShowName("1122");
        userService.saveUser(user);

        transation3Test.server3();
    }
}
