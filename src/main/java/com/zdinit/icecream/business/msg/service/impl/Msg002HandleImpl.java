package com.zdinit.icecream.business.msg.service.impl;

import com.zdinit.icecream.business.msg.entity.AbstractMsg;
import com.zdinit.icecream.business.msg.service.AbstractMsgHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Msg002HandleImpl extends AbstractMsgHandle {

    @Override
    public void handle(AbstractMsg msg) {
        log.info("处理报文002");
    }
}
