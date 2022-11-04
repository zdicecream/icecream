package com.zdinit.icecream.sys.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.zdinit.icecream.common.BaseController;
import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.utils.ResponseUtil;
import com.zdinit.icecream.sys.entity.User;
import com.zdinit.icecream.sys.service.IGroupService;
import com.zdinit.icecream.sys.service.IResourceService;
import com.zdinit.icecream.sys.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zd
 * @since 2020-09-01
 */
@Slf4j
@RestController
@RequestMapping("/sys")
public class LoginController extends BaseController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IResourceService resourceService;
    @Autowired
    private IGroupService groupService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponse login(@RequestBody User userInfo){

        User user = userService.judge(userInfo.getUsername(),userInfo.getPassword());
        if (user == null) {
            return ResponseUtil.error("无此用户");
        }
        if (!userInfo.getPassword().equals(user.getPassword())) {
            return ResponseUtil.error("密码错误");
        }
        StpUtil.login(user.getId());
        log.info(StpUtil.getTokenValue());
        return ResponseUtil.sucess(StpUtil.getTokenInfo());
    }

    @RequestMapping(value = "/isLogin", method = RequestMethod.POST)
    public BaseResponse isLogin(){
        return ResponseUtil.sucess("当前会话是否登录：" + StpUtil.isLogin());
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public BaseResponse logout(){
        StpUtil.logout();
        return ResponseUtil.sucess("已登出");
    }

}
