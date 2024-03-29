package com.zdinit.icecream.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zdinit.icecream.common.BaseController;
import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.utils.ResponseUtil;
import com.zdinit.icecream.sys.entity.Resource;
import com.zdinit.icecream.sys.entity.Role;
import com.zdinit.icecream.sys.entity.User;
import com.zdinit.icecream.sys.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zd
 * @since 2021-06-10
 */
@RestController
@RequestMapping("/sys/resource")
public class ResourceController extends BaseController {

    @Autowired
    private IResourceService resourceService;

    @RequestMapping(value = "/getAllResourceList", method = RequestMethod.GET)
    public BaseResponse getAllResourceList(){
        List<Resource> resourceList = this.resourceService.list();
        /**
         * 组装权限列表
         */
        List<Resource> menuList = this.resourceService.pack(resourceList);
        return ResponseUtil.sucess(menuList);
    }

    @RequestMapping(value = "/getResourceList", method = RequestMethod.GET)
    public BaseResponse getResourceList(Resource resource){
        /**
         * 按条件查询
         */
        QueryWrapper<Resource> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("pid");
        queryWrapper.orderByAsc("orders");
        Page<Resource> resourcePage = this.resourceService.page(this.page(),queryWrapper);
        /**
         * 构建树
         */
        List<Resource> resourceList = this.resourceService.tree(resourcePage.getRecords());
        resourcePage.setRecords(resourceList);
        return ResponseUtil.sucess(resourcePage);
    }
    @RequestMapping(value = "/saveResource", method = RequestMethod.POST)
    public BaseResponse saveResource(@RequestBody Resource resource){
        this.resourceService.saveResource(resource);
        return ResponseUtil.sucess(null);
    }

    @RequestMapping(value = "/delResource", method = RequestMethod.POST)
    public BaseResponse delResource(@RequestParam Long id){
        List<Role> roles = this.resourceService.listRoleByResourceId(id);
        if (roles == null || roles.size()<=0) {
            this.resourceService.removeResourceById(id);
        }else {
            StringBuilder sb = new StringBuilder();
            roles.forEach(user -> sb.append(user.getRoleName()+","));
            return ResponseUtil.error("无法删除权限，尚有角色勾选此权限："+sb.toString());
        }
        return ResponseUtil.sucess(null);
    }
}
