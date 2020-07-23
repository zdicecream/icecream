package com.zdinit.icecream.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class TMenu extends Model<TMenu> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String menuName;

    private String url;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
