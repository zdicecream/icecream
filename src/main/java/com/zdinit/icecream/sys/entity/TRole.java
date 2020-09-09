package com.zdinit.icecream.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zd
 * @since 2020-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TRole extends Model<TRole> {

    private static final long serialVersionUID = 1L;

    /**
     * ??ID
     */
    @TableId("ID")
    private String id;

    /**
     * ????
     */
    @TableField("R_NAME")
    private String rName;

    /**
     * ????
     */
    @TableField("R_DESC")
    private String rDesc;

    /**
     * ??????
     */
    @TableField("R_TIME")
    private LocalDateTime rTime;

    /**
     * ????
     */
    @TableField("R_SCOPE")
    private String rScope;

    /**
     * ????
     */
    @TableField("R_AMOUNT")
    private BigDecimal rAmount;

    /**
     * ??????
     */
    @TableField("R_PRODUCT_TYPE")
    private String rProductType;

    /**
     * 角色编号
     */
    @TableField("R_CODE")
    private String rCode;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
