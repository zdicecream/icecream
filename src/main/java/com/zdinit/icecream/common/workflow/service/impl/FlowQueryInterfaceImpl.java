package com.zdinit.icecream.common.workflow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zdinit.icecream.common.CommonValue;
import com.zdinit.icecream.common.workflow.entity.WfFlowhistory;
import com.zdinit.icecream.common.workflow.entity.WfNode;
import com.zdinit.icecream.common.workflow.entity.WfWorkflow;
import com.zdinit.icecream.common.workflow.service.IFlowQueryInterface;
import com.zdinit.icecream.common.workflow.service.IWfFlowhistoryService;
import com.zdinit.icecream.common.workflow.service.IWfNodeService;
import com.zdinit.icecream.common.workflow.service.IWfWorkflowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlowQueryInterfaceImpl implements IFlowQueryInterface {
    @Autowired
    private IWfWorkflowService workflowService;
    @Autowired
    private IWfFlowhistoryService flowhistoryService;
    @Autowired
    private IWfNodeService nodeService;

    @Override
    public List<WfWorkflow> queryUnSubmitFlow(Long id) {
        QueryWrapper<WfWorkflow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", CommonValue.FLOW_BUILT);
        queryWrapper.eq("commit_user_id",id);
        return workflowService.list(queryWrapper);
    }

    @Override
    public List<WfWorkflow> querySubmittedFlow(Long id,Long roleId) {
        QueryWrapper<WfWorkflow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", CommonValue.FLOW_SUBMIT);
        queryWrapper.and(w->w.eq("commit_user_id",id).or().eq("cur_deal_role_id",roleId));
        return workflowService.list(queryWrapper);
    }

    @Override
    public List<WfWorkflow> queryFinishedFlow(Long id) {
        QueryWrapper<WfWorkflow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", CommonValue.FLOW_CLOSE);
        queryWrapper.eq("commit_user_id",id);
        return workflowService.list(queryWrapper);
    }

    @Override
    public List<WfNode> queryFlowMonitor(Long flowId) {
        QueryWrapper<WfNode> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("flow_id",flowId);
        return nodeService.list(queryWrapper);
    }

    @Override
    public List<WfFlowhistory> queryFlowHistory(Long id) {
        QueryWrapper<WfFlowhistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("wordflow_Id",id);
        return flowhistoryService.list(queryWrapper);
    }
}
