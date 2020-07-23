package com.zdinit.icecream.sys.controller;


import com.zdinit.icecream.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zd
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void test(){
        userService.testNew();;
    }

}
