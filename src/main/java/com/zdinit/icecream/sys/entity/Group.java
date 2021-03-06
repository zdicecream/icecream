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
 * @since 2021-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_group")
public class Group extends Model<Group> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String groupName;

    private String groupCode;

    private Long pid;

    private Integer state;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
