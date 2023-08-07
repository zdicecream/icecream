package com.zdinit.icecream.auth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class Group {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String groupName;

    private String groupCode;

    private Long pid;

    private Integer state;

}
