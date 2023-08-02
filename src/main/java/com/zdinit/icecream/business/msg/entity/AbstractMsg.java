package com.zdinit.icecream.business.msg.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * msg抽象类
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractMsg {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String msgId;

    private String msgCode;

    private Integer state;

    private LocalDateTime createTime;

    protected Serializable pkVal() {
        return this.id;
    }

}
