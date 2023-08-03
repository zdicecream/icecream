package com.zdinit.icecream;

import com.zdinit.icecream.auth.entity.User;
import com.zdinit.icecream.auth.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransationTest {
    @Autowired
    private IUserService userService;
    @Autowired
    private Transation2Test transation2Test;
    @Test
    @Transactional(rollbackFor = Exception.class)
    public void server1(){
        User user = new User();
        user.setShowName("11");
        userService.saveUser(user);


        transation2Test.server2();

        user = new User();
        user.setShowName("111111");
        userService.saveUser(user);
    }


}
