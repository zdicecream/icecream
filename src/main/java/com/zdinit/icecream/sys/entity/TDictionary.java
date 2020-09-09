package com.zdinit.icecream.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TDictionary extends Model<TDictionary> {

    private static final long serialVersionUID = 1L;

    /**
     * ??
     */
    @TableId("ID")
    private String id;

    /**
     * ????
     */
    @TableField("D_CODE")
    private String dCode;

    /**
     * ????
     */
    @TableField("D_CODENAME")
    private String dCodename;

    /**
     * ????
     */
    @TableField("D_SHORTNAME")
    private String dShortname;

    /**
     * ???
     */
    @TableField("D_PARENTCODE")
    private String dParentcode;

    @TableField("D_LEVEL")
    private BigDecimal dLevel;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
