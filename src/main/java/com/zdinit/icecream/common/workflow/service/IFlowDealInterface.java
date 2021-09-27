package com.zdinit.icecream.common.workflow.service;

import com.zdinit.icecream.common.workflow.entity.WfWorkflow;
import com.zdinit.icecream.sys.entity.User;

import java.util.List;

public interface IFlowDealInterface {

    /**
     * 新建
     * @param userId 提交人id
     * @param username 提交人名称
     * @param deptId 部门id
     * @param deptName 部门名称
     * @param busId 业务表id
     * @param flowId 审批流id
     * @return 新建审批流编号
     */
    String built(Long userId,String username,Long deptId,String deptName,Long busId,Long flowId);

    /**
     * 修改
     */
    void revise(WfWorkflow workflow);

    /**
     * 提交
     */
    void submit(Long workflowId);

    /**
     * 批量提交
     */
    void submit(List<Long> workflowIds);

    /**
     * 关闭
     */
    void close(Long workflowId);

    /**
     * 批量关闭
     */
    void close(List<Long> workflowIds);

    /**
     * 删除(仅限未提交状态的流程)
     */
    void delete(Long workflowId) throws Exception;

    /**
     * 批量删除(仅限未提交状态的流程)
     */
    void delete(List<Long> workflowIds) throws Exception;

    /**
     * 审批
     */
    void approve(Long workflowId,String dealOpinion,User dealUser);

    /**
     * 批量审批
     */
    void approve(List<Long> workflowIds,String dealOpinion,User dealUser);

    /**
     * 撤回提交
     */
    void revoke(Long workflowId)throws Exception;

    /**
     * 批量撤回提交
     */
    void revoke(List<Long> workflowIds)throws Exception;

    /**
     * 驳回上一岗
     */
    void rejectToPrevious(Long workflowId,String dealOpinion);

    /**
     * 批量驳回上一岗
     */
    void rejectToPrevious(List<Long> workflowIds,String dealOpinion);

    /**
     * 驳回到开始
     */
    void rejectToBegin(Long workflowId,String dealOpinion);

    /**
     * 批量驳回到开始
     */
    void rejectToBegin(List<Long> workflowIds,String dealOpinion);
}
