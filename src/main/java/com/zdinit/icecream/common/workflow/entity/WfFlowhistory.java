package com.zdinit.icecream.common.workflow.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zd
 * @since 2021-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WfFlowhistory {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long workflowId;

    private LocalDateTime dealTime;

    private String dealUser;

    private String dealRole;

    private String dealResult;

    private String dealOpinion;
}
