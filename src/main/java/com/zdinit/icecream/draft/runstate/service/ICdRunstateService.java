package com.zdinit.icecream.draft.runstate.service;

import com.zdinit.icecream.draft.runstate.entity.CdRunstate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zd
 * @since 2020-09-02
 */
public interface ICdRunstateService extends IService<CdRunstate> {

    void testTran(CdRunstate cdRunstate);

}
