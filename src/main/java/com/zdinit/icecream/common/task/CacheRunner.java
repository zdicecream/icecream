package com.zdinit.icecream.common.task;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zdinit.icecream.common.utils.RedisUtil;
import com.zdinit.icecream.sys.entity.TDictionary;
import com.zdinit.icecream.sys.service.ITDictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2)
@Slf4j
public class CacheRunner implements CommandLineRunner {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ITDictionaryService dictionaryService;

    @Override
    public void run(String... args) throws Exception {

        List<TDictionary> dictionaryList = dictionaryService.list();
        for (TDictionary dictionary : dictionaryList) {
            redisUtil.set(dictionary.getDCode(),dictionary.getDCodename());
        }

    }
}
