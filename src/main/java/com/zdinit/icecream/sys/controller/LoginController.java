package com.zdinit.icecream.sys.controller;


import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.utils.RedisUtil;
import com.zdinit.icecream.common.utils.ResponseUtil;
import com.zdinit.icecream.sys.entity.TDepartment;
import com.zdinit.icecream.sys.entity.TResource;
import com.zdinit.icecream.sys.entity.TUser;
import com.zdinit.icecream.sys.service.ITDepartmentService;
import com.zdinit.icecream.sys.service.ITResourceService;
import com.zdinit.icecream.sys.service.ITUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zd
 * @since 2020-09-01
 */
@RestController
@RequestMapping("/sys")
public class LoginController {
    @Autowired
    private ITUserService userService;
    @Autowired
    private ITDepartmentService departmentService;
    @Autowired
    private ITResourceService resourceService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse login(@RequestParam String name,@RequestParam String password) throws Exception {

        TUser user = userService.judge(name,password);
        Map map = new HashMap();
        if (user == null) {
            map.put("login","error");
            map.put("msg","无此用户");
            return ResponseUtil.sucess(map);
        }
        if (!password.equals(user.getUPassword())) {
            map.put("login","error");
            map.put("msg","密码错误");
            return ResponseUtil.sucess(map);
        }
        TDepartment department = departmentService.getById(user.getUDeptid());
        if (department == null) {
            return ResponseUtil.error();
        }
        List<TResource> resourceList = resourceService.listResourceByUserId(user.getId());
        map.put("login","success");
        map.put("msg","登陆成功");
        map.put("department",department.getDName());
        map.put("role",resourceList.size());
        return ResponseUtil.sucess(map);
    }


    @RequestMapping(value = "/msgSend", method = RequestMethod.POST)
    public BaseResponse msgSend(@RequestParam String channel,@RequestParam String msg) throws Exception {
        redisUtil.Publish(channel,msg);
        return ResponseUtil.sucess();
    }

}
