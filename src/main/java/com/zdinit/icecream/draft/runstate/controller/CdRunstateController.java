package com.zdinit.icecream.draft.runstate.controller;


import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.utils.RedisUtil;
import com.zdinit.icecream.common.utils.ResponseUtil;
import com.zdinit.icecream.draft.runstate.service.ICdRunstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
public class CdRunstateController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/getRunstate", method = RequestMethod.GET)
    public BaseResponse getRunstate() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("bankname", redisUtil.get("bankname"));
        return ResponseUtil.sucess(map);
    }
}
