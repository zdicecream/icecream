package com.zdinit.icecream.sys.controller;


import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.utils.ResponseUtil;
import com.zdinit.icecream.sys.entity.Perple;
import com.zdinit.icecream.sys.service.IPerpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zd
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/sys/perple")
public class PerpleController {
    @Autowired
    private IPerpleService perpleService;
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public BaseResponse test(){

        Perple perple = new Perple();
//        perple.setName("");
        perple.setAge(2);
        perpleService.save(perple);
        return ResponseUtil.sucess();
    }
    @RequestMapping(value = "/getTest",method = RequestMethod.GET)
    public BaseResponse<Perple> getTest(){
        List<Perple> list = perpleService.list();
        return ResponseUtil.sucess(list);
    }

    @RequestMapping(value = "/getTest1",method = RequestMethod.GET)
    public BaseResponse<Perple> getTest1(@RequestParam String id){
        List<Perple> list = perpleService.list();
        Perple perple = list.get(0);
        return ResponseUtil.sucess(perple);
    }
    @RequestMapping(value = "/getTest2",method = RequestMethod.GET)
    public BaseResponse<Perple> getTest2() throws Exception {
        List<Perple> list = perpleService.list();
        Perple perple = list.get(0);
        if (perple != null) {
            throw new Exception("1");
        }
        return ResponseUtil.sucess(perple);
    }

}
