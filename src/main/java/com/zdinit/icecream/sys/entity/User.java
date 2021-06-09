package com.zdinit.icecream.sys.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zd
 * @since 2021-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class User extends Model<User>{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    private String showname;

    private String mobile;

    private String email;

    private LocalDateTime createTime;

    private LocalDateTime lastLoginTime;

    private Integer loginCount;

    private Long groupId;

    private Integer state;

    @TableField(exist = false)
    private List RoleList;
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
