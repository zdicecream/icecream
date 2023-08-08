package com.zdinit.icecream.auth.controller;


import com.zdinit.icecream.auth.entity.Runstate;
import com.zdinit.icecream.auth.service.IRunstateService;
import com.zdinit.icecream.common.BaseController;
import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.CommonValue;
import com.zdinit.icecream.common.aop.ClearRedis;
import com.zdinit.icecream.common.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
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
@RequestMapping("/sys/runstate")
@Slf4j
public class RunstateController extends BaseController{

    @Autowired
    private IRunstateService runstateService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 无参数
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getRunstate", method = RequestMethod.GET)
    public BaseResponse getRunstate(){
        String date = (String) redisTemplate.opsForHash().get(CommonValue.SYSTEM,"sysDate");
        String state = (String) redisTemplate.opsForHash().get(CommonValue.SYSTEM,"sysState");
        if (state == null || date == null) {
            Runstate runstate = runstateService.getOne(null);
            date = runstate.getSysdate().format(DateTimeFormatter.ISO_DATE);
            state = runstate.getSysstate();
            redisTemplate.opsForHash().put(CommonValue.SYSTEM,"sysDate",date);
            redisTemplate.opsForHash().put(CommonValue.SYSTEM,"sysState",state);
        }
        Map map = new HashMap();
        map.put("sysDate",date);
        map.put("sysState",state);
        return ResponseUtil.sucess(map);
    }

    /**
     * 有参数，且为json格式的，用@RequestBody接收
     * @param runstate
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateRunstate", method = RequestMethod.POST)
    @ClearRedis(name = CommonValue.SYSTEM)
    public BaseResponse updateRunstate(@RequestBody Runstate runstate){
        Runstate curRunstate = runstateService.getOne(null);
        curRunstate.setSysdate(runstate.getSysdate());
        curRunstate.setSysstate(runstate.getSysstate());
        runstateService.saveOrUpdate(curRunstate);
        return ResponseUtil.sucess();
    }

}
