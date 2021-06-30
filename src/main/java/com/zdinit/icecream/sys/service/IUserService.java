package com.zdinit.icecream.sys.service;

import com.zdinit.icecream.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zd
 * @since 2021-05-10
 */
public interface IUserService extends IService<User> {

    User judge(String name, String password);

    void saveUser(User user);

    void removeUserById(String id);

    List<User> listUserByRoleId(Long id);
}
