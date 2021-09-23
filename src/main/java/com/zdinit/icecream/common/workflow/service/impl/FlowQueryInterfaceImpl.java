package com.zdinit.icecream.common.workflow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zdinit.icecream.common.CommonValue;
import com.zdinit.icecream.common.workflow.entity.WfFlowhistory;
import com.zdinit.icecream.common.workflow.entity.WfWorkflow;
import com.zdinit.icecream.common.workflow.service.IFlowQueryInterface;
import com.zdinit.icecream.common.workflow.service.IWfFlowhistoryService;
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

    @Override
    public List<WfWorkflow> queryUnSubmitFlow(Long id) {
        QueryWrapper<WfWorkflow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", CommonValue.FLOW_BUILT);
        queryWrapper.eq("commit_user_id",id);
        return workflowService.list(queryWrapper);
    }

    @Override
    public List<WfWorkflow> querySubmittedFlow() {
        QueryWrapper<WfWorkflow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", CommonValue.FLOW_SUBMIT);
        return workflowService.list(queryWrapper);
    }

    @Override
    public List<WfWorkflow> queryFinishedFlow() {
        QueryWrapper<WfWorkflow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", CommonValue.FLOW_CLOSE);
        return workflowService.list(queryWrapper);
    }

    @Override
    public WfWorkflow queryFlowMonitor() {
        return null;
    }

    @Override
    public List<WfFlowhistory> queryFlowHistory(Long id) {
        QueryWrapper<WfFlowhistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("wordflow_Id",id);
        return flowhistoryService.list(queryWrapper);
    }
}
