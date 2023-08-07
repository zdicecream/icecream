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
 * @since 2021-09-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WfWorkflow {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String workflowNum;

    private LocalDateTime startTime;

    private LocalDateTime finishTime;

    private String curDealRole;

    private Long curDealRoleId;

    private String curDealUser;

    private Integer state;

    private Long flowId;

    private Long nodeId;

    private String commitUsername;

    private Long commitUserId;

    private String commitGroupName;

    private Long commitGroupId;

    private Long busId;

    private Long preDealUserId;

}
