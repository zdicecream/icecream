package com.zdinit.icecream.sys.service;

import com.zdinit.icecream.sys.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zd
 * @since 2020-09-01
 */
public interface ITUserService extends IService<TUser> {

    TUser judge(String name, String password);
}
