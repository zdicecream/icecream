package com.zdinit.icecream.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zd
 * @since 2020-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Integer age;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
