package com.zdinit.icecream.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.zdinit.icecream.sys.entity.Role;
import com.zdinit.icecream.sys.mapper.RoleMapper;
import com.zdinit.icecream.sys.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdinit.icecream.sys.vo.RoleVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zd
 * @since 2021-05-06
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<RoleVo> listRoleByIds(List<Long> list) {
        return this.baseMapper.listRoleById(list);
    }

    @Override
    public List<Role> listRoleByUserId(Long id) {
        return this.baseMapper.listRoleByUserId(id);
    }
}
