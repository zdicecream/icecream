package com.zdinit.icecream.sys.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.zdinit.icecream.common.BaseController;
import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.utils.ResponseUtil;
import com.zdinit.icecream.sys.entity.User;
import com.zdinit.icecream.sys.service.IGroupService;
import com.zdinit.icecream.sys.service.IResourceService;
import com.zdinit.icecream.sys.service.IUserService;
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
    public BaseResponse login(@RequestBody User userInfo) throws Exception {

        User user = userService.judge(userInfo.getUsername(),userInfo.getPassword());
        if (user == null) {
            return ResponseUtil.error("无此用户");
        }
        if (!userInfo.getPassword().equals(user.getPassword())) {
            return ResponseUtil.error("密码错误");
        }
        StpUtil.login(user.getId());
        return ResponseUtil.sucess(StpUtil.getTokenInfo());
    }

    @RequestMapping(value = "/isLogin", method = RequestMethod.POST)
    public BaseResponse isLogin(@RequestParam String name,@RequestParam String password) throws Exception {
        return ResponseUtil.sucess("当前会话是否登录：" + StpUtil.isLogin());
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public BaseResponse logout() throws Exception {
        StpUtil.logout();
        return ResponseUtil.sucess("已登出");
    }

}
