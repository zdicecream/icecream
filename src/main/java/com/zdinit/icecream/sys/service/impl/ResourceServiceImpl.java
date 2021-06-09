package com.zdinit.icecream.sys.service.impl;

import com.zdinit.icecream.sys.entity.Resource;
import com.zdinit.icecream.sys.mapper.ResourceMapper;
import com.zdinit.icecream.sys.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zd
 * @since 2021-05-06
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

}
