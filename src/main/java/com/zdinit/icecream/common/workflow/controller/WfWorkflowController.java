package com.zdinit.icecream.common.workflow.controller;


import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.utils.ResponseUtil;
import com.zdinit.icecream.common.workflow.entity.WfWorkflow;
import com.zdinit.icecream.common.workflow.service.IFlowDealInterface;
import com.zdinit.icecream.common.workflow.service.IWfWorkflowService;
import com.zdinit.icecream.sys.entity.Group;
import com.zdinit.icecream.sys.entity.User;
import com.zdinit.icecream.sys.service.IGroupService;
import com.zdinit.icecream.sys.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zd
 * @since 2021-09-18
 */
@Slf4j
@RestController
@RequestMapping("/common/workflow/wfWorkflow")
public class WfWorkflowController {

    @Autowired
    private IFlowDealInterface flowDealInterface;
    @Autowired
    private IUserService userService;
    @Autowired
    private IGroupService groupService;
    @Autowired
    private IWfWorkflowService workflowService;

    @RequestMapping(value = "/built", method = RequestMethod.POST)
    public BaseResponse built(@RequestParam Long busId,@RequestParam Long flowId) throws Exception {
        User user = userService.getById(StpUtil.getLoginIdAsLong());
        Group group = groupService.getById(user.getGroupId());
        String num = flowDealInterface.built(user.getId(),user.getUsername(),group.getId(),group.getGroupName(),busId,flowId);
        log.info("创建工作流num成功");


        QueryWrapper<WfWorkflow> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("workflow_num",num);
        WfWorkflow workflow = workflowService.getOne(queryWrapper);
        flowDealInterface.submit(workflow.getId());
        flowDealInterface.revoke(workflow.getId());
        return ResponseUtil.sucess(num);
    }

}
