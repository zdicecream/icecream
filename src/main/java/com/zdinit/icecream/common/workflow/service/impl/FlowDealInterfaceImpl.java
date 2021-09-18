package com.zdinit.icecream.common.workflow.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zdinit.icecream.common.CommonValue;
import com.zdinit.icecream.common.workflow.entity.WfFlowhistory;
import com.zdinit.icecream.common.workflow.entity.WfNode;
import com.zdinit.icecream.common.workflow.entity.WfWorkflow;
import com.zdinit.icecream.common.workflow.service.*;
import com.zdinit.icecream.sys.entity.User;
import com.zdinit.icecream.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlowDealInterfaceImpl implements IFlowDealInterface{

    @Autowired
    private IWfFlowService flowService;
    @Autowired
    private IWfNodeService nodeService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IWfWorkflowService workflowService;
    @Autowired
    private IWfFlowhistoryService flowhistoryService;

    @Override
    public String built(Long userId, String username, Long deptId, String deptName, Long busId,Long flowId) {
        WfWorkflow workflow = new WfWorkflow();
        workflow.setCommitUserId(userId);
        workflow.setCommitUsername(username);
        workflow.setCommitGroupId(deptId);
        workflow.setCommitGroupName(deptName);
        workflow.setBusId(busId);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmmss");
        workflow.setWorkflowNum(userId.toString().substring(0,10)+LocalDateTime.now().format(dtf));
        workflow.setStartTime(LocalDateTime.now());

        QueryWrapper<WfNode> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("flow_id",flowId);
        queryWrapper.isNull("previous_node_id");
        WfNode node = nodeService.getOne(queryWrapper);
        workflow.setCurDealRole(node.getDealRole());
        workflow.setCurDealRoleId(node.getDealRoleId());

        List<User> userList = userService.listUserByRoleId(workflow.getCurDealRoleId());
        workflow.setCurDealUser(userList.stream().map(user -> user.getUsername()).collect(Collectors.joining(" ")));

        workflow.setState(CommonValue.FLOW_BUILT);
        workflow.setFlowId(flowId);
        workflow.setNodeId(node.getId());
        this.workflowService.save(workflow);

        return workflow.getWorkflowNum();
    }

    @Override
    public void revise(WfWorkflow workflow) {

    }

    @Override
    public void submit(Long workflowId) {
        List<Long> workflowIds = new ArrayList<>();
        workflowIds.add(workflowId);
        this.submit(workflowIds);
    }

    @Override
    public void submit(List<Long> workflowIds) {
        for (Long l:workflowIds){
            WfWorkflow wfWorkflow = this.workflowService.getById(l);
            wfWorkflow.setState(CommonValue.FLOW_SUBMIT);
            this.workflowService.save(wfWorkflow);
        }
    }

    @Override
    public void close(Long workflowId) {
        List<Long> workflowIds = new ArrayList<>();
        workflowIds.add(workflowId);
        this.close(workflowIds);
    }

    @Override
    public void close(List<Long> workflowIds) {
        for (Long l:workflowIds){
            WfWorkflow wfWorkflow = this.workflowService.getById(l);
            wfWorkflow.setState(CommonValue.FLOW_CLOSE);
            this.workflowService.save(wfWorkflow);
        }
    }

    @Override
    public void delete(Long workflowId)  throws Exception{
        List<Long> workflowIds = new ArrayList<>();
        workflowIds.add(workflowId);
        this.delete(workflowIds);
    }

    @Override
    public void delete(List<Long> workflowIds) throws Exception{
        for (Long l:workflowIds){
            WfWorkflow wfWorkflow = this.workflowService.getById(l);
            if (wfWorkflow.getState().equals(CommonValue.FLOW_SUBMIT)){
                throw new Exception("清选择未提交或者已结束状态的流程");
            }
            this.workflowService.removeById(l);
        }
    }

    @Override
    public void approve(Long workflowId, String dealOpinion,User dealUser) {
        List<Long> workflowIds = new ArrayList<>();
        workflowIds.add(workflowId);
        this.approve(workflowIds,dealOpinion,dealUser);
    }

    @Override
    public void approve(List<Long> workflowIds, String dealOpinion,User dealUser) {
        for (Long l:workflowIds){
            WfWorkflow wfWorkflow = this.workflowService.getById(l);
            WfNode node = this.nodeService.getById(wfWorkflow.getNodeId());
            WfNode next = this.nodeService.getById(node.getNextNodeId());
            wfWorkflow.setNodeId(next.getId());
            wfWorkflow.setPreDealUserId(dealUser.getId());
            wfWorkflow.setCurDealRole(next.getDealRole());
            wfWorkflow.setCurDealRoleId(next.getDealRoleId());
            List<User> userList = this.userService.listUserByRoleId(next.getDealRoleId());
            wfWorkflow.setCurDealUser(userList.stream().map(user -> user.getUsername()).collect(Collectors.joining(" ")));
            this.workflowService.save(wfWorkflow);
            /**
             * 记录审批记录
             */
            flowhistoryService.saveHistory(wfWorkflow,CommonValue.FLOW_YES,dealOpinion);
        }
    }

    @Override
    public void revoke(Long workflowId) {
        List<Long> workflowIds = new ArrayList<>();
        workflowIds.add(workflowId);
        this.revoke(workflowIds);
    }

    @Override
    public void revoke(List<Long> workflowIds) {
        for (Long l:workflowIds){
            WfWorkflow wfWorkflow = this.workflowService.getById(l);
            WfNode node = this.nodeService.getById(wfWorkflow.getNodeId());
            WfNode pre = this.nodeService.getById(node.getPreviousNodeId());
            wfWorkflow.setNodeId(pre.getId());
            wfWorkflow.setCurDealRole(pre.getDealRole());
            wfWorkflow.setCurDealRoleId(pre.getDealRoleId());
            List<User> userList = this.userService.listUserByRoleId(pre.getDealRoleId());
            wfWorkflow.setCurDealUser(userList.stream().map(user -> user.getUsername()).collect(Collectors.joining(" ")));
            this.workflowService.save(wfWorkflow);
            /**
             * 记录审批记录
             */
            flowhistoryService.saveHistory(wfWorkflow,CommonValue.FLOW_NO,"撤回");
        }
    }

    @Override
    public void rejectToPrevious(Long workflowId, String dealOpinion) {
        List<Long> workflowIds = new ArrayList<>();
        workflowIds.add(workflowId);
        this.rejectToPrevious(workflowIds,dealOpinion);
    }

    @Override
    public void rejectToPrevious(List<Long> workflowIds, String dealOpinion) {
        for (Long l:workflowIds){
            WfWorkflow wfWorkflow = this.workflowService.getById(l);
            WfNode node = this.nodeService.getById(wfWorkflow.getNodeId());
            WfNode pre = this.nodeService.getById(node.getPreviousNodeId());
            wfWorkflow.setNodeId(pre.getId());
            wfWorkflow.setCurDealRole(pre.getDealRole());
            wfWorkflow.setCurDealRoleId(pre.getDealRoleId());
            List<User> userList = this.userService.listUserByRoleId(pre.getDealRoleId());
            wfWorkflow.setCurDealUser(userList.stream().map(user -> user.getUsername()).collect(Collectors.joining(" ")));
            this.workflowService.save(wfWorkflow);
            /**
             * 记录审批记录
             */
            flowhistoryService.saveHistory(wfWorkflow,CommonValue.FLOW_NO,dealOpinion);
        }
    }

    @Override
    public void rejectToBegin(Long workflowId, String dealOpinion) {
        List<Long> workflowIds = new ArrayList<>();
        workflowIds.add(workflowId);
        this.rejectToBegin(workflowIds,dealOpinion);
    }

    @Override
    public void rejectToBegin(List<Long> workflowIds, String dealOpinion) {
        for (Long l:workflowIds){
            WfWorkflow wfWorkflow = this.workflowService.getById(l);
            wfWorkflow.setNodeId(null);
            wfWorkflow.setCurDealRole(null);
            wfWorkflow.setCurDealRoleId(null);
            wfWorkflow.setPreDealUserId(null);
            wfWorkflow.setCurDealUser(null);
            wfWorkflow.setState(CommonValue.FLOW_BUILT);
            this.workflowService.save(wfWorkflow);
            /**
             * 记录审批记录
             */
            flowhistoryService.saveHistory(wfWorkflow,CommonValue.FLOW_NO,dealOpinion);
        }
    }
}
