package com.zdinit.icecream.common.workflow.entity;

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
 * @since 2021-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WfFlow extends Model<WfFlow> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String flowDescript;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
