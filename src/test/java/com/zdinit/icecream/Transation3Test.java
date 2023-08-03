package com.zdinit.icecream;

import com.zdinit.icecream.auth.entity.User;
import com.zdinit.icecream.auth.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Transation3Test {
    @Autowired
    private IUserService userService;
    @Transactional
    public void server3(){
        User user = new User();
        user.setShowName("112233");
        userService.saveUser(user);
        throw new RuntimeException("11");
    }
}
