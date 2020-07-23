package com.zdinit.icecream.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zdinit.icecream.common.BaseResponse;
import com.zdinit.icecream.common.utils.RedisUtil;
import com.zdinit.icecream.common.utils.ResponseUtil;
import com.zdinit.icecream.sys.entity.TDictionary;
import com.zdinit.icecream.sys.service.ITDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/sys/dictionary")
public class TDictionaryController {
    @Autowired
    private ITDictionaryService dictionaryService;
    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public BaseResponse test(){
        Page page = new Page(1,10);
        IPage<TDictionary> iPage = dictionaryService.page(page);
        System.out.println(redisUtil.get("CD_114"));
        return ResponseUtil.sucess();
    }
}

