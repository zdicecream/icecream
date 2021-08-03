package com.zdinit.icecream.msg.service.impl;

import com.zdinit.icecream.msg.entity.AbstractMsg;
import com.zdinit.icecream.msg.service.IMsgHandle;
import lombok.extern.slf4j.Slf4j;

/**
 * msg处理通用处理类
 */
@Slf4j
public abstract class AbstractMsgHandle implements IMsgHandle {

    @Override
    public void receive(AbstractMsg msg) {
        AbstractMsg msgExist = null;
        if(msgExist!=null){
            log.info("报文重复，不再执行");
            return;
        }
        this.handle(msg);
    }

}
