package com.zdinit.icecream.sys.mapper;

import com.zdinit.icecream.sys.entity.TResource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zd
 * @since 2020-09-01
 */
public interface TResourceMapper extends BaseMapper<TResource> {

    List<TResource> listResourceByUserId(String id);
}
