package com.zdinit.icecream.sys.service;

import com.zdinit.icecream.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zd
 * @since 2020-06-09
 */
public interface IUserService extends IService<User> {
    void testNew();
}
