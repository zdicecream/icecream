package com.zdinit.icecream.sys.mapper;

import com.zdinit.icecream.sys.entity.Resource;
import com.zdinit.icecream.sys.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdinit.icecream.sys.vo.RoleVo;
import org.apache.ibatis.annotations.Select;

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
