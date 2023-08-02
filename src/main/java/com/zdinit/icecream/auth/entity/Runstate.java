package com.zdinit.icecream.auth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zd
 * @since 2020-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_runstate")
public class Runstate extends Model<Runstate> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date sysdate;

    private String sysstate;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
