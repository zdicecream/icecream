package com.zdinit.icecream.sys.service.impl;

import com.zdinit.icecream.sys.entity.TResource;
import com.zdinit.icecream.sys.mapper.TResourceMapper;
import com.zdinit.icecream.sys.service.ITResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zd
 * @since 2020-09-01
 */
@Service
public class TResourceServiceImpl extends ServiceImpl<TResourceMapper, TResource> implements ITResourceService {

    @Override
    public List<TResource> listResourceByUserId(String id) {

        return this.getBaseMapper().listResourceByUserId(id);
    }
}
