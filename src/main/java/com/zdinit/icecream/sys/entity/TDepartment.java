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
public class TDepartment extends Model<TDepartment> {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @TableField("D_CODE")
    private String dCode;

    /**
     * ??
     */
    @TableField("D_NAME")
    private String dName;

    /**
     * ??
     */
    @TableField("D_DESC")
    private String dDesc;

    /**
     * ??
     */
    @TableField("D_ORDER")
    private BigDecimal dOrder;

    /**
     * ????ID
     */
    @TableField("D_PID")
    private String dPid;

    /**
     * ?? 0 ??? 1 ??
     */
    @TableField("D_STATUS")
    private BigDecimal dStatus;

    /**
     * ???? ?? ??1 ??2?3
     */
    @TableField("D_LEVEL")
    private BigDecimal dLevel;

    /**
     * ID???????/??
     */
    @TableField("D_TREECODE")
    private String dTreecode;

    /**
     * 0 ?? 1 ??
     */
    @TableField("D_ISORG")
    private BigDecimal dIsorg;

    /**
     * ????????
     */
    @TableField("D_BANKNUMBER")
    private String dBanknumber;

    /**
     * ??????
     */
    @TableField("D_ORGCODE")
    private String dOrgcode;

    /**
     * ??????
     */
    @TableField("D_INNERBANKCODE")
    private String dInnerbankcode;

    /**
     * ???????
     */
    @TableField("D_AUDITBANKCODE")
    private String dAuditbankcode;

    /**
     * ?????
     */
    @TableField("IS_BRANCH")
    private String isBranch;

    /**
     * ????id
     */
    @TableField("D_STOCKDEPT")
    private String dStockdept;

    /**
     * ????
     */
    @TableField("ADDRESS")
    private String address;

    /**
     * ?????1:???? 2:???? 3:?????
     */
    @TableField("ACPTDEPT")
    private String acptdept;

    /**
     * ??????id
     */
    @TableField("D_DISCOUNTDTOCKDEPT")
    private String dDiscountdtockdept;

    @TableField("COLLECTIONACCOUNT")
    private String collectionaccount;

    @TableField("AREACODE")
    private String areacode;

    @TableField("LEVEL_CODE")
    private String levelCode;

    /**
     * ??????? 0 ? 1 ?
     */
    @TableField("MAINBRA_FLG")
    private String mainbraFlg;

    /**
     * ??????
     */
    @TableField("PJS_BRCH_NO")
    private String pjsBrchNo;

    /**
     * ????????
     */
    @TableField("PJS_USER_NO")
    private String pjsUserNo;

    /**
     * ?????????
     */
    @TableField("PJS_USER_NAME")
    private String pjsUserName;

    /**
     * ??????
     */
    @TableField("DEPART_SOCIAL_CODE")
    private String departSocialCode;

    /**
     * ???????
     */
    @TableField("PJS_DEPART_NAME")
    private String pjsDepartName;

    @TableField("PJS_ROLE")
    private String pjsRole;

    @TableField("PJS_MEMBER_CODE")
    private String pjsMemberCode;

    @TableField("CPR_BRCH_NO")
    private String cprBrchNo;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
