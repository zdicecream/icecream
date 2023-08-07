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
public class WfNode {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nodeName;

    private String dealRole;

    private Long dealRoleId;

    private Long flowId;

    private Long previousNodeId;

    private Long nextNodeId;

}
