package com.zdinit.icecream.config;

import cn.dev33.satoken.stp.StpInterface;
import com.zdinit.icecream.common.CommonValue;
import com.zdinit.icecream.sys.service.IResourceService;
import com.zdinit.icecream.sys.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 */
@Component    // 保证此类被SpringBoot扫描，完成Sa-Token的自定义权限验证扩展
public class SaTokenPermission implements StpInterface {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IResourceService resourceService;
    @Autowired
    private IRoleService roleService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<String> permissionList = (List<String>) redisTemplate.opsForList().range("Resource:"+loginId,0,-1);
        if (permissionList == null || permissionList.size() <= 0) {
            permissionList = resourceService.listResourceByUserId(Long.parseLong((String) loginId)).stream().filter(m->m.getType().equals(CommonValue.MENU)).map(m-> m.getResourceCode()).collect(Collectors.toList());
            redisTemplate.opsForList().leftPushAll("Resource:"+loginId,permissionList);
        }
        redisTemplate.expire("Resource:"+loginId,30 * 60, TimeUnit.SECONDS);
        return permissionList;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        List<String> roleList = (List<String>) redisTemplate.opsForList().range("Role:"+loginId,0,-1);
        if (roleList == null) {
            roleList = roleService.listRoleByUserId((Long) loginId).stream().map(role -> role.getRoleName()).collect(Collectors.toList());
            redisTemplate.opsForList().leftPushAll("Role:"+loginId,roleList);
        }
        redisTemplate.expire("Role:"+loginId,30 * 60, TimeUnit.SECONDS);
        return roleList;
    }
}
