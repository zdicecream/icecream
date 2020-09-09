package com.zdinit.icecream.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zdinit.icecream.sys.entity.TUser;
import com.zdinit.icecream.sys.mapper.TUserMapper;
import com.zdinit.icecream.sys.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zd
 * @since 2020-09-01
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    @Override
    public TUser judge(String name, String password) {
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("U_LOGINNAME",name);
        return this.getOne(wrapper);
    }
}
