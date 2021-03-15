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
    private String id;

    /**
     * ??????
     */
    @TableField("RS_BANKNAME")
    private String rsBankname;

    /**
     * ???ID
     */
    @TableField("RS_APID")
    private String rsApid;

    /**
     * ?????
     */
    @TableField("RS_APNAME")
    private String rsApname;

    /**
     * ?????????/???/????/????????????????????????
     */
    @TableField("RS_LOGONSTATE")
    private String rsLogonstate;

    /**
     * ?????
     */
    @TableField("RS_OLDPWD")
    private String rsOldpwd;

    /**
     * ?????
     */
    @TableField("RS_NEWPWD")
    private String rsNewpwd;

    /**
     * ?????
     */
    @TableField("RS_ORGNLSYSDT")
    private Date rsOrgnlsysdt;

    /**
     * ?????
     */
    @TableField("RS_ORGNLSYSSTS")
    private String rsOrgnlsyssts;

    /**
     * ??????
     */
    @TableField("RS_CURDATE")
    private Date rsCurdate;

    /**
     * ??????
     */
    @TableField("RS_SYSSTATE")
    private String rsSysstate;

    /**
     * ????????
     */
    @TableField("RS_NEXTDATE")
    private Date rsNextdate;

    /**
     * ??????
     */
    @TableField("RS_BIZREFTM")
    private String rsBizreftm;

    /**
     * ??
     */
    @TableField("RS_RMRK")
    private String rsRmrk;

    /**
     * ??????
     */
    @TableField("RS_CRLFILE")
    private String rsCrlfile;

    /**
     * ??????
     */
    @TableField("RS_CRLLASTUPDATETIME")
    private Date rsCrllastupdatetime;

    /**
     * ????????
     */
    @TableField("RS_PRCMSG")
    private String rsPrcmsg;

    /**
     * ???????
     */
    @TableField("RS_PRCCD")
    private String rsPrccd;

    /**
     * ??????
     */
    @TableField("RS_BANKCODE")
    private String rsBankcode;

    /**
     * ????
     */
    @TableField("RS_PFXPATH")
    private String rsPfxpath;

    /**
     * ????
     */
    @TableField("RS_PFXPASSWORD")
    private String rsPfxpassword;

    /**
     * CRL??????
     */
    @TableField("RS_CRLPATH")
    private String rsCrlpath;

    /**
     * ??????
     */
    @TableField("RS_STTLMONLINEMRK")
    private String rsSttlmonlinemrk;

    /**
     * ??????
     */
    @TableField("RS_STTLMONLINERMRK")
    private String rsSttlmonlinermrk;

    /**
     * ????????? 
     */
    @TableField("RS_HVPSNXTSYSDT")
    private Date rsHvpsnxtsysdt;

    /**
     * ??NPC??
     */
    @TableField("RS_NPCCODE")
    private String rsNpccode;

    /**
     * ??????
     */
    @TableField("RS_PFXFILENAME")
    private String rsPfxfilename;

    /**
     * ????????
     */
    @TableField("RS_UNIFYKEY")
    private String rsUnifykey;

    /**
     * ccNPC ??
     */
    @TableField("RS_NPCSTATUS")
    private String rsNpcstatus;

    /**
     * pc?
     */
    @TableField("RS_CCPCCODE")
    private String rsCcpccode;

    /**
     * ccpc??
     */
    @TableField("RS_CCPCSTATUS")
    private String rsCcpcstatus;

    @TableField("RS_SYSPARTNER")
    private String rsSyspartner;

    /**
     * ??????????
     */
    @TableField("RS_OPERSWITCH")
    private String rsOperswitch;

    /**
     * ????
     */
    @TableField("RS_SWITCHTYPE")
    private String rsSwitchtype;





    @TableField("RS_WORKDATE")
    private Date workDate;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
