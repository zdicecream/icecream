package com.zdinit.icecream.common.workflow.service;

import com.zdinit.icecream.common.workflow.entity.WfFlowhistory;
import com.zdinit.icecream.common.workflow.entity.WfNode;
import com.zdinit.icecream.common.workflow.entity.WfWorkflow;

import java.util.List;

public interface IFlowQueryInterface {

    /**
     * 查询未提交的流程
     * @param id 提交人id
     * @return
     */
    List<WfWorkflow> queryUnSubmitFlow(Long id);

    /**
     * 查询审批中的流程
     */
    List<WfWorkflow> querySubmittedFlow(Long id,Long roleId);

    /**
     * 查询已结束的流程
     */
    List<WfWorkflow> queryFinishedFlow(Long id);

    /**
     * 当前流程监控
     * @param flowId 审批流表id
     * @return
     */
    List<WfNode> queryFlowMonitor(Long flowId);

    /**
     * 查询流程审批历史
     */
    List<WfFlowhistory> queryFlowHistory(Long id);
}
