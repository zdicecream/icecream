package com.zdinit.icecream.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zdinit.icecream.common.BaseController;
import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.utils.ResponseUtil;
import com.zdinit.icecream.sys.entity.Role;
import com.zdinit.icecream.sys.entity.User;
import com.zdinit.icecream.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zd
 * @since 2021-05-06
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController extends BaseController {
    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "/getRoleList", method = RequestMethod.GET)
    public BaseResponse getRoleList(User user) throws Exception {
        List<Role> roleList = roleService.list();
        return ResponseUtil.sucess(roleList);
    }
}
