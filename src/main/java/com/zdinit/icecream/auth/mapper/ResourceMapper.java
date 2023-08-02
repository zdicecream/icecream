package com.zdinit.icecream.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdinit.icecream.auth.entity.Resource;
import com.zdinit.icecream.auth.entity.Role;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zd
 * @since 2021-06-10
 */
public interface ResourceMapper extends BaseMapper<Resource> {

    List<Resource> listResourceByids(List keys);

    List<Resource> listResourceByid(Long id);

    void delResource(Long roleId, Long resourceId);

    void delResourceByRoleId(Long roleId);

    void addResource(Long roleId, Long resourceId);

    List<Role> listRoleByResourceId(Long id);

    List<Resource> listResourceByUserId(Long id);
}