package com.zdinit.icecream.draft.runstate.service.impl;

import com.zdinit.icecream.draft.runstate.entity.CdRunstate;
import com.zdinit.icecream.draft.runstate.mapper.CdRunstateMapper;
import com.zdinit.icecream.draft.runstate.service.ICdRunstateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
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
public class CdRunstateServiceImpl extends ServiceImpl<CdRunstateMapper, CdRunstate> implements ICdRunstateService {
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void testTran(CdRunstate cdRunstate){
        this.saveOrUpdate(cdRunstate);
        CdRunstate c = new CdRunstate();
        c.setWorkDate(new Date());
        this.save(c);
    }

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

    ;
}
