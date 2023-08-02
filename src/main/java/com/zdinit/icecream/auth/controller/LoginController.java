package com.zdinit.icecream.auth.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.zdinit.icecream.auth.entity.User;
import com.zdinit.icecream.auth.service.IGroupService;
import com.zdinit.icecream.auth.service.IResourceService;
import com.zdinit.icecream.auth.service.IRoleService;
import com.zdinit.icecream.auth.service.IUserService;
import com.zdinit.icecream.common.BaseController;
import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.CommonValue;
import com.zdinit.icecream.common.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IRoleService roleService;

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

        //权限
        List<String> permissionList = resourceService.listResourceByUserId(user.getId()).stream().filter(m->m.getType().equals(CommonValue.MENU)).map(m-> m.getResourceCode()).collect(Collectors.toList());
        if(!redisTemplate.opsForHash().hasKey(CommonValue.TOKEN_NAME+user.getId(),"resource")){
            redisTemplate.opsForHash().put(CommonValue.TOKEN_NAME+user.getId(),"resource",permissionList);
        }
        redisTemplate.expire(CommonValue.TOKEN_NAME+user.getId(),30 * 60, TimeUnit.SECONDS);
        //角色
        List<String> roleList = roleService.listRoleByUserId(user.getId()).stream().map(role -> role.getRoleName()).collect(Collectors.toList());
        if(!redisTemplate.opsForHash().hasKey(CommonValue.TOKEN_NAME+user.getId(),"role")){
            redisTemplate.opsForHash().put(CommonValue.TOKEN_NAME+user.getId(),"role",roleList);
        }
        redisTemplate.expire(CommonValue.TOKEN_NAME+user.getId(),30 * 60, TimeUnit.SECONDS);

        log.info(StpUtil.getTokenValue());
        return ResponseUtil.sucess(StpUtil.getTokenInfo());
    }

    @RequestMapping(value = "/isLogin", method = RequestMethod.POST)
    public BaseResponse isLogin(){
        return ResponseUtil.sucess("当前会话是否登录：" + StpUtil.isLogin());
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public BaseResponse logout(){
        redisTemplate.opsForHash().delete(CommonValue.TOKEN_NAME+StpUtil.getLoginId(),"resource");
        redisTemplate.opsForHash().delete(CommonValue.TOKEN_NAME+StpUtil.getLoginId(),"role");
        StpUtil.logout();
        return ResponseUtil.sucess("已登出");
    }

}
