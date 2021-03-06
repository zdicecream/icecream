package com.zdinit.icecream.config;

import cn.dev33.satoken.stp.StpInterface;
import com.zdinit.icecream.common.CommonValue;
import com.zdinit.icecream.sys.service.IResourceService;
import com.zdinit.icecream.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 */
@Component    // 保证此类被SpringBoot扫描，完成Sa-Token的自定义权限验证扩展
public class SaTokenPermission implements StpInterface {
    @Autowired
    private IResourceService resourceService;
    @Autowired
    private IRoleService roleService;

    @Override
    public List<String> getPermissionList(Object o, String s) {
        return resourceService.listResourceByUserId(Long.parseLong((String) o)).stream().filter(m->m.getType().equals(CommonValue.MENU)).map(m-> m.getResourceCode()).collect(Collectors.toList());
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        return roleService.list().stream().map(role -> role.getRoleName()).collect(Collectors.toList());
    }
}
