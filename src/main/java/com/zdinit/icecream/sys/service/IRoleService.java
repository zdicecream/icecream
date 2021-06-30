package com.zdinit.icecream.sys.service;

import com.zdinit.icecream.sys.entity.Resource;
import com.zdinit.icecream.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zdinit.icecream.sys.vo.RoleVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zd
 * @since 2021-05-06
 */
public interface IRoleService extends IService<Role> {
    List<RoleVo> listRoleByIds(List<Long> list);

    List<Role> listRoleByUserId(Long id);

    void saveRole(Role role);

    void removeRoleById(Long id);
}
