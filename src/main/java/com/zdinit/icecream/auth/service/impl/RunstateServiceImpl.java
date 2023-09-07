package com.zdinit.icecream.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zdinit.icecream.auth.entity.Runstate;
import com.zdinit.icecream.auth.mapper.RunstateMapper;
import com.zdinit.icecream.auth.service.IRunstateService;
import com.zdinit.icecream.common.CommonValue;
import com.zdinit.icecream.common.aop.ClearRedis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zd
 * @since 2020-09-02
 */
@Service
@Slf4j
public class RunstateServiceImpl extends ServiceImpl<RunstateMapper, Runstate> implements IRunstateService {

    public void filterList() throws Exception {
        /**
         * 筛选指定条件的list，两种模式（重sql，重java）
         */
        /**
         * 重java
         */
        List<String> stringList = new ArrayList<>();
        stringList = stringList.stream().filter(s -> "11".equals(s)).collect(Collectors.toList());

        /**
         * 重sql

          "select * from xxx where a>b";
         */

    }

    @Override
    @ClearRedis(name = CommonValue.SYSTEM)
    public void testSave(Runstate runstate) {
        this.baseMapper.insert(runstate);
    }
}
