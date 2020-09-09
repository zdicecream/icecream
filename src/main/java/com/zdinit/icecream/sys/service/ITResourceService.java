package com.zdinit.icecream.sys.service;

import com.zdinit.icecream.sys.entity.TResource;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zd
 * @since 2020-09-01
 */
public interface ITResourceService extends IService<TResource> {

    List<TResource> listResourceByUserId(String id);
}
