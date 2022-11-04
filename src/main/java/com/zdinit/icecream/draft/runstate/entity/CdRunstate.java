package com.zdinit.icecream.draft.runstate.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class CdRunstate extends Model<CdRunstate> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private Long id;

    @TableField("RS_CURDATE")
    private Date rsCurdate;

    @TableField("RS_SYSSTATE")
    private String rsSysstate;

    @TableField("RS_RMRK")
    private String rsRmrk;

    @TableField("RS_WORKDATE")
    private Date workDate;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
