package com.zdinit.icecream.common.workflow.service;

import com.zdinit.icecream.common.workflow.entity.WfFlowhistory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zdinit.icecream.common.workflow.entity.WfWorkflow;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zd
 * @since 2021-09-22
 */
public interface IWfFlowhistoryService extends IService<WfFlowhistory> {

    void saveHistory(WfWorkflow wfWorkflow, String dealResult, String dealOpinion);
}
