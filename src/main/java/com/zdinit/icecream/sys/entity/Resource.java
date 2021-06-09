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
@TableName("sys_resource")
public class Resource extends Model<Resource> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private Long pid;

    private Integer order;

    private Integer level;

    private String url;

    private String icon;

    private Integer type;

    private Integer state;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
