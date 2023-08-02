package com.zdinit.icecream.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zdinit.icecream.auth.entity.User;

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
