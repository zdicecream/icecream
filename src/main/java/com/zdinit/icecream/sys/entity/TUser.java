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
public class TUser extends Model<TUser> {

    private static final long serialVersionUID = 1L;

    /**
     * ??ID
     */
    @TableId("ID")
    private String id;

    /**
     * ???
     */
    @TableField("U_LOGINNAME")
    private String uLoginname;

    /**
     * ??
     */
    @TableField("U_PASSWORD")
    private String uPassword;

    /**
     * ???
     */
    @TableField("U_NAME")
    private String uName;

    /**
     * ???1-???0-???
     */
    @TableField("U_STATUS")
    private BigDecimal uStatus;

    /**
     * ????
     */
    @TableField("U_TIME")
    private LocalDateTime uTime;

    /**
     * ??ID
     */
    @TableField("U_DEPTID")
    private String uDeptid;

    /**
     * ????
     */
    @TableField("U_EMAIL")
    private String uEmail;

    /**
     * ??
     */
    @TableField("U_TELPHONE")
    private String uTelphone;

    /**
     * ????ID
     */
    @TableField("C_CUSTMANAGERID")
    private String cCustmanagerid;

    /**
     * ??????
     */
    @TableField("C_CUSTNUM")
    private String cCustnum;

    /**
     * ??????
     */
    @TableField("C_CUSTNAME")
    private String cCustname;

    /**
     * ??????
     */
    @TableField("U_PSSWDUPDATE")
    private LocalDateTime uPsswdupdate;

    @TableField("U_CUSTMANAGERFLAG")
    private String uCustmanagerflag;

    @TableField("U_CUSTEXECUTIVEFLAG")
    private String uCustexecutiveflag;

    @TableField("C_PASSWD_TIME")
    private String cPasswdTime;

    @TableField("C_LOGIN_TIME")
    private String cLoginTime;

    @TableField("C_OLD_PASSWD")
    private String cOldPasswd;

    @TableField("AGENT_FLAG")
    private String agentFlag;

    /**
     * ????? 1-?????
     */
    @TableField("ADMIN_FLAG")
    private String adminFlag;

    /**
     * ?????????
     */
    @TableField("PJS_USER_NO")
    private String pjsUserNo;

    /**
     * ?????????
     */
    @TableField("PJS_USER_NAME")
    private String pjsUserName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
