package com.zdinit.icecream.msg.service.impl;

import com.zdinit.icecream.msg.entity.AbstractMsg;
import com.zdinit.icecream.msg.service.AbstractMsgHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Order(1)
public class Msg002HandleImpl extends AbstractMsgHandle {

    @Override
    public void handle(AbstractMsg msg) {
        log.info("处理报文002");
    }
}
