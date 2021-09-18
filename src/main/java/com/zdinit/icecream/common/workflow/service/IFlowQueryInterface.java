package com.zdinit.icecream.common.workflow.service;

public interface IFlowQueryInterface {

    /**
     * 查询未提交的流程
     */
    void queryUnSubmitFlow();

    /**
     * 查询审批中的流程
     */
    void querySubmittedFlow();

    /**
     * 查询已结束的流程
     */
    void queryFinishedFlow();

    /**
     * 当前流程监控
     */
    void queryFlowMonitor();

    /**
     * 查询流程审批历史
     */
    void queryFlowHistory();
}
