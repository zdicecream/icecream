package com.zdinit.icecream.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.utils.ResponseUtil;
import com.zdinit.icecream.sys.entity.TUser;
import com.zdinit.icecream.sys.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zd
 * @since 2020-09-01
 */
@RestController
@RequestMapping("/sys/t-user")
public class TUserController {
    @Autowired
    private ITUserService userService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public BaseResponse getUserList(@RequestParam String name, @RequestParam String password) throws Exception {
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        Page page = new Page(1,2);
        IPage<TUser> userList = userService.page( page,wrapper);
        return ResponseUtil.sucess(userList);
    }
}
