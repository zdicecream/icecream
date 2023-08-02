package com.zdinit.icecream.auth.vo;

import lombok.Data;

@Data
public class RoleVo {
    private Long id;
    private String rolename;
    private Integer state;
    private Long userId;
}
