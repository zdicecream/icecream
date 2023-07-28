package com.zdinit.icecream.draft.runstate.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.utils.ResponseUtil;
import com.zdinit.icecream.draft.runstate.entity.CdRunstate;
import com.zdinit.icecream.draft.runstate.service.ICdRunstateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zd
 * @since 2020-09-02
 */
@RestController
@RequestMapping("/draft/cd-runstate")
@Slf4j
public class CdRunstateController {

    @Autowired
    private ICdRunstateService runstateService;

    @RequestMapping(value = "/getRunstate", method = RequestMethod.GET)
    public BaseResponse getRunstate(){
        Map<String, String> map = new HashMap<>();
        return ResponseUtil.sucess(map);
    }

    /**
     * 无参数
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getRunstate1", method = RequestMethod.GET)
    public BaseResponse getRunstate1(){
        List<CdRunstate> cdRunstateList = runstateService.list();
        return ResponseUtil.sucess(cdRunstateList);
    }

    /**
     * 有参数，且为json格式的，用@RequestBody接收
     * @param cdRunstate
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addRunstate", method = RequestMethod.POST)
    public BaseResponse addRunstate(@RequestBody CdRunstate cdRunstate){

        cdRunstate.setWorkDate(new Date());
        runstateService.save(cdRunstate);
        runstateService.testTran(cdRunstate);
        return ResponseUtil.sucess();
    }

    /**
     * 有参数，且为 id=id形式用@RequestParam
     * @param cdRunstateList
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delRunstate", method = RequestMethod.POST)
    public BaseResponse delRunstate(@RequestParam List<String> cdRunstateList){
        runstateService.removeByIds(cdRunstateList);
        return ResponseUtil.sucess();
    }

    @RequestMapping(value = "/updateRunstate", method = RequestMethod.POST)
    public BaseResponse updateRunstate(@RequestBody CdRunstate cdRunstate){
        CdRunstate cdRunstateCur = runstateService.getById(cdRunstate.getId());
        if (cdRunstateCur != null) {
            cdRunstateCur.setWorkDate(new Date());
            runstateService.updateById(cdRunstateCur);
        }
        return ResponseUtil.sucess();
    }

    /**
     * Page参数
     * @param page
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getRunstatePage", method = RequestMethod.GET)
    public BaseResponse getRunstatePage(@RequestBody Page page){
        Page<CdRunstate> cdRunstateList = runstateService.page(page);
        return ResponseUtil.sucess(cdRunstateList);
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public BaseResponse test(){

        return ResponseUtil.sucess();
    }
}
