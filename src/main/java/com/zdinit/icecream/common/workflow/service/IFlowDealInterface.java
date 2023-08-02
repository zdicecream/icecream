package com.zdinit.icecream.common.workflow.service;

import com.zdinit.icecream.common.workflow.entity.WfWorkflow;
import com.zdinit.icecream.auth.entity.User;

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
     * 撤回提交
     */
    void revoke(Long workflowId);

    /**
     * 批量撤回提交
     */
    void revoke(List<Long> workflowIds);

    /**
     * 删除(仅限未提交、驳回状态的流程)
     */
    void delete(Long workflowId);

    /**
     * 批量删除(仅限未提交、驳回状态的流程)
     */
    void delete(List<Long> workflowIds);

    /**
     * 审批
     */
    void approve(Long workflowId,String dealOpinion,User dealUser);

    /**
     * 批量审批
     */
    void approve(List<Long> workflowIds,String dealOpinion,User dealUser);

    /**
     * 调整至指定岗
     */
    void adjust(Long workflowId,Long adjustWorkflowId,String dealOpinion);

    /**
     * 驳回
     */
    void reject(Long workflowId,String dealOpinion);

    /**
     * 批量驳回
     */
    void reject(List<Long> workflowIds,String dealOpinion);

    /**
     * 关闭（跳过流程直接关闭）
     */
    void close(Long workflowId);

    /**
     * 批量关闭（跳过流程直接关闭）
     */
    void close(List<Long> workflowIds);

    /**
     * 直接改为驳回状态
     * @param workflowId
     */
    void cancel(Long workflowId,String dealOpinion);

    /**
     * 直接改为驳回状态
     * @param workflowIds
     */
    void cancel(List<Long> workflowIds,String dealOpinion);

    /**
     * 挂起
     * @param workflowId
     * @param dealOpinion
     */
    void suspend(Long workflowId,String dealOpinion);

    /**
     * 挂起
     * @param workflowIds
     * @param dealOpinion
     */
    void suspend(List<Long> workflowIds,String dealOpinion);

}
