package com.zdinit.icecream.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdinit.icecream.auth.entity.Group;
import com.zdinit.icecream.auth.mapper.GroupMapper;
import com.zdinit.icecream.auth.service.IGroupService;
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
