package com.zdinit.icecream.common.workflow.service.impl;

import com.zdinit.icecream.common.workflow.entity.WfFlowhistory;
import com.zdinit.icecream.common.workflow.entity.WfWorkflow;
import com.zdinit.icecream.common.workflow.mapper.WfFlowhistoryMapper;
import com.zdinit.icecream.common.workflow.service.IWfFlowhistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zd
 * @since 2021-09-22
 */
@Service
public class WfFlowhistoryServiceImpl extends ServiceImpl<WfFlowhistoryMapper, WfFlowhistory> implements IWfFlowhistoryService {
    @Override
    public void saveHistory(WfWorkflow wfWorkflow, String dealResult, String dealOpinion) {
        WfFlowhistory flowhistory = new WfFlowhistory();
        flowhistory.setWorkflowId(wfWorkflow.getId());
        flowhistory.setDealOpinion(dealOpinion);
        flowhistory.setDealResult(dealResult);
        flowhistory.setDealTime(LocalDateTime.now());
        flowhistory.setDealRole(wfWorkflow.getCurDealRole());
        flowhistory.setDealUser(wfWorkflow.getCurDealUser());
        this.baseMapper.insert(flowhistory);
    }
}
