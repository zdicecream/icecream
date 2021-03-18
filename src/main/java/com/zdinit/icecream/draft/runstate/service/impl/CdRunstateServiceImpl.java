package com.zdinit.icecream.draft.runstate.service.impl;

import com.zdinit.icecream.draft.runstate.entity.CdRunstate;
import com.zdinit.icecream.draft.runstate.mapper.CdRunstateMapper;
import com.zdinit.icecream.draft.runstate.service.ICdRunstateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
    @Transactional
    public void testTran(CdRunstate cdRunstate) throws Exception {
        this.saveOrUpdate(cdRunstate);
        CdRunstate c = new CdRunstate();

        c.setWorkDate(new Date());
        c.setRsApid("123");
        this.save(c);
    };
}
