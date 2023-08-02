package com.zdinit.icecream.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdinit.icecream.auth.entity.Role;
import com.zdinit.icecream.auth.vo.RoleVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zd
 * @since 2021-05-06
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<RoleVo> listRoleByIds(List<Long> list);

    List<Role> listRoleByUserId(Long id);

}
