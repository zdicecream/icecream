package com.zdinit.icecream.sys.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zdinit.icecream.common.BaseController;
import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.CommonValue;
import com.zdinit.icecream.common.utils.ResponseUtil;
import com.zdinit.icecream.sys.entity.Resource;
import com.zdinit.icecream.sys.entity.User;
import com.zdinit.icecream.sys.service.IResourceService;
import com.zdinit.icecream.sys.service.IRoleService;
import com.zdinit.icecream.sys.service.IUserService;
import com.zdinit.icecream.sys.vo.RoleVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zd
 * @since 2021-05-10
 */
@RestController
@RequestMapping("/sys/user")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IResourceService resourceService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public BaseResponse getUserList(User user) throws Exception {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (null != user.getState()){
            wrapper.eq("state",user.getState());
        }
        if (StringUtils.isNotBlank(user.getUsername())){
            wrapper.and(w-> w.likeLeft("username",user.getUsername()).or().likeRight("username",user.getUsername()));
        }
        IPage<User> userList = userService.page(page(),wrapper);

        if (userList.getTotal()>0) {
            List<Long> ksyList = new ArrayList<>();
            userList.getRecords().forEach(user1 -> ksyList.add(user1.getId()));
            List<RoleVo> roleList = roleService.listRoleByIds(ksyList);

            for (User u:
                    userList.getRecords()) {
                List<RoleVo> roles = roleList.stream().filter(role -> role.getUserId().equals(u.getId())).collect(Collectors.toList());
                u.setRoleList(roles);
            }
        }
        return ResponseUtil.sucess(userList);
    }

    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public BaseResponse delUser(@RequestParam String id) throws Exception {
        userService.removeUserById(id);
        return ResponseUtil.sucess(null);
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public BaseResponse saveUser(@RequestBody User user) throws Exception {
        userService.saveUser(user);
        return ResponseUtil.sucess(null);
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public BaseResponse getUserInfo() throws Exception {
        User u = userService.getById(StpUtil.getLoginIdAsLong());
        List<Resource> resources = resourceService.listResourceByUserId(StpUtil.getLoginIdAsLong());
        List<Resource> menuList = this.resourceService.pack(resources);
        u.setResourceList(menuList);

        Map<String,Object> map = new HashMap<>();
        map.put("user",u);
        map.put("resources",resources.stream().filter(m->m.getType().equals(CommonValue.MENU)).map(m->m.getResourceCode()).collect(Collectors.toList()));
        return ResponseUtil.sucess(map);
    }
}
