package com.zdinit.icecream.sys.service.impl;

import com.zdinit.icecream.sys.entity.Group;
import com.zdinit.icecream.sys.mapper.GroupMapper;
import com.zdinit.icecream.sys.service.IGroupService;
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
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements IGroupService {

}
