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
 * @since 2020-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TResource extends Model<TResource> {

    private static final long serialVersionUID = 1L;

    /**
     * ????ID
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
     * ????--???????
     */
    @TableField("R_CODE")
    private String rCode;

    /**
     * ???? 5 menu|?? 10 operation|??(???file????)
     */
    @TableField("R_TYPE")
    private BigDecimal rType;

    /**
     * ????
     */
    @TableField("R_ORDER")
    private BigDecimal rOrder;

    /**
     * ?????Action??
     */
    @TableField("R_ACTION")
    private String rAction;

    /**
     * menu???????
     */
    @TableField("R_URL")
    private String rUrl;

    /**
     * ???ID
     */
    @TableField("R_PID")
    private String rPid;

    @TableField("R_ICONCSS")
    private String rIconcss;

    @TableField("SHOW_NAME")
    private String showName;

    @TableField("ROOT_ID")
    private String rootId;

    @TableField("IS_SHOW")
    private BigDecimal isShow;

    @TableField("R_SORT")
    private BigDecimal rSort;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
