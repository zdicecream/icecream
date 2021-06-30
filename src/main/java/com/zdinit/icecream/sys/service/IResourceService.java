package com.zdinit.icecream.sys.service;

import com.zdinit.icecream.sys.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zdinit.icecream.sys.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zd
 * @since 2021-06-10
 */
public interface IResourceService extends IService<Resource> {

    List<Resource> listResourceByids(List keys);

    List<Resource> pack(List<Resource> resourceList);

    List<Resource> listResourceById(Long id);

    void delResource(Long roleId, Long resourceId);

    void addResource(Long roleId, Long resourceId);

    void delResourceByRoleId(Long id);

    List<Resource> tree(List<Resource> menuList);

    void saveResource(Resource resource);

    List<Role> listRoleByResourceId(Long id);

    void removeResourceById(Long id);

    List<String> listResourceNameByUserId(Long id);
}
