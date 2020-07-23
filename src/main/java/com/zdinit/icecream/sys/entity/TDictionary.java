package com.zdinit.icecream.sys.entity;

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
 * @since 2020-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TDictionary extends Model<TDictionary> {

    private static final long serialVersionUID = 1L;

    private String id;

    private String dCode;

    private String dCodename;

    private String dShortname;

    private String dParentcode;

    private Integer dLevel;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
