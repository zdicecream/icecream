package com.zdinit.icecream.sys.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

@Data
public class RoleVo {
    private Long id;
    private String rolename;
    private Integer state;
    private Long userId;
}
