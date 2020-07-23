package com.zdinit.icecream.sys.service.impl;

import com.zdinit.icecream.sys.entity.User;
import com.zdinit.icecream.sys.mapper.UserMapper;
import com.zdinit.icecream.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zd
 * @since 2020-06-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public void testNew() {
        this.getBaseMapper().test();
    }
}
